package com.zzu.controller;

import com.zzu.model.Good;
import com.zzu.repository.GoodRepository;
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
}
