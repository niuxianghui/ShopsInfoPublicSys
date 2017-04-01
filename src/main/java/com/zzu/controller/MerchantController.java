package com.zzu.controller;

import com.zzu.model.Merchant;
import com.zzu.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
