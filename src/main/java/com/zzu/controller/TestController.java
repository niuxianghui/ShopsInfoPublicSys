package com.zzu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by niuxianghui on 17/3/21.
 */
@RestController
public class TestController {

    @RequestMapping(value = "/")
    public String test(){
        return "hello world";
    }
}
