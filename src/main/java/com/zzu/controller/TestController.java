package com.zzu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by niuxianghui on 17/3/21.
 */
@RestController
public class TestController {
    @RequestMapping(value = "/showsession", method = RequestMethod.GET)
    public String sessionTest(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        if (session.getAttribute("hello") != null){
            return (String)session.getAttribute("hello");
        }
        return "sb";
    }
    @RequestMapping(value = "/setSession", method = RequestMethod.GET)
    public String test(@RequestParam(value = "value", required = true)String value, HttpServletRequest request, HttpServletResponse response){
        System.out.println("hello");
        HttpSession session = request.getSession();
        session.setAttribute("hello", value);
        return "hello";
    }
}
