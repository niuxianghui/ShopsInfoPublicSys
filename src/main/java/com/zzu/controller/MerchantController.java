package com.zzu.controller;

import com.alibaba.fastjson.JSON;
import com.zzu.model.Merchant;
import com.zzu.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by niuxianghui on 17/4/1.
 */
@RestController
@RequestMapping("/api")
public class MerchantController {
    @Autowired
    private MerchantRepository merchantRepository;
    @RequestMapping("/getMerchantsByCategory")
    public List<Merchant> getMerchants(@RequestParam(value = "category", required = true)String category){
        //System.out.println(category);
        List<Merchant> merchantList = merchantRepository.findByCategory(category);
        return merchantList;
    }

    @RequestMapping("/getMerchantById")
    public Merchant getMerchantById(@RequestParam(value = "id", required = true)long id){
        Merchant merchant = merchantRepository.findOne(id);
        return merchant;
    }

    @RequestMapping(value = "/updateMerchant", method = RequestMethod.POST)
    public Object changeInfo(@RequestParam(value = "id", required = true)Long id,
                           @RequestParam(value = "introduction", required = true)String intro,
                           @RequestParam(value = "address", required = true)String address,
                           @RequestParam(value = "phoneNumber", required = true)String phoneNumber) {
        Merchant merchant = merchantRepository.findOne(id);
        Object result = null;
        if (merchant == null) {
            result = JSON.parse("{code: 400, msg: 'failure to get merchant'}");
        }
        merchant.setIntroduction(intro);
        merchant.setAddress(address);
        merchant.setPhoneNumber(phoneNumber);
        merchantRepository.save(merchant);
        result = JSON.parse("{code: 200, msg: 'update success.'}");
        return result;
    }

    @RequestMapping(value = "/merchant/{id}", method = RequestMethod.PATCH)
    public Object patch(@PathVariable(value = "id")Long id,
                      @RequestBody String value) {
        Merchant merchant = merchantRepository.findOne(id);
        Merchant info = JSON.parseObject(value, Merchant.class);
        merchant.setIntroduction(info.getIntroduction());
        merchant.setPhoneNumber(info.getPhoneNumber());
        merchant.setAddress(info.getAddress());
        merchantRepository.save(merchant);
        return JSON.parse("{code: 200, msg: 'success', id: " + merchant.getId() + "}");
    }
}
