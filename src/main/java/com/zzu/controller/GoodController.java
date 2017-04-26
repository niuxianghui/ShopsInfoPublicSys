package com.zzu.controller;

import com.alibaba.fastjson.JSON;
import com.zzu.model.Good;
import com.zzu.repository.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by niuxianghui on 17/4/1.
 */
@RestController
@RequestMapping("/api")
public class GoodController {
    @Autowired
    private GoodRepository goodRepository;
    @RequestMapping("/getGoodByMerchant")
    public List<Good> getGoodByMerchant(@RequestParam(value = "id", required = true)long merchantId){
        List<Good> goods = goodRepository.findByMerchantId(merchantId);
        for (Good item: goods) {
            item.setKey(item.getId().toString());
        }
        return goods;
    }

    @RequestMapping(value = "/good/{id}", method = RequestMethod.PATCH)
    public Object patchGood(@PathVariable(value = "id")Long id, @RequestBody String value){
        Good good = goodRepository.findOne(id);
        Good newGood = JSON.parseObject(value, Good.class);
        good.setIntroduction(newGood.getIntroduction());
        good.setName(newGood.getName());
        good.setPrice(newGood.getPrice());
        goodRepository.save(good);
        return JSON.parse("{code: 200, msg: 'success.', id: " + good.getMerchantId() + "}");
    }

    @RequestMapping(value = "/good", method = RequestMethod.PUT)
    public Object createGood(@RequestBody String value){
        Good good = JSON.parseObject(value, Good.class);
        goodRepository.save(good);
        return JSON.parse("{code: 200, msg: 'success.'}");
    }

    @RequestMapping(value = "/good/{id}", method = RequestMethod.DELETE)
    public Object deleteGood(@PathVariable(value = "id")Long id) {
        goodRepository.delete(id);
        return JSON.parse("{code: 200, msg: 'success.'}");
    }
}
