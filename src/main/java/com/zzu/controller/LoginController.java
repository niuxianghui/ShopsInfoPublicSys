package com.zzu.controller;

import com.alibaba.fastjson.JSON;
import com.zzu.model.Admin;
import com.zzu.model.Merchant;
import com.zzu.model.User;
import com.zzu.repository.AdminRepository;
import com.zzu.repository.MerchantRepository;
import com.zzu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by niuxianghui on 17/4/4.
 */
@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private MerchantRepository merchantRepository;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object login(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "name", required = true)String name,
                        @RequestParam(value = "passwd", required = true)String passwd){
        User user = userRepository.findByName(name);
        if (user == null){
            return JSON.parse("{code: 400, msg: 'failure to login!'}");
        }
        if(user.getPassWd().equals(passwd)){
            request.getSession().setAttribute(user.getName(), user);
            return JSON.parse("{code: 200, msg: 'success!'}");
        }
        return JSON.parse("{code: 400, msg: 'failure to login!'}");
    }

    @RequestMapping(value = "/adminLogin", method = RequestMethod.POST)
    public Object adminlogin(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "name", required = true)String name,
                        @RequestParam(value = "passwd", required = true)String passwd){
        Admin user = adminRepository.findByName(name);
        if (user == null){
            return JSON.parse("{code: 400, msg: 'failure to login!'}");
        }
        if(user.getPassWd().equals(passwd)){
            request.getSession().setAttribute(user.getName(), user);
            return JSON.parse("{code: 200, msg: 'success!'}");
        }
        return JSON.parse("{code: 400, msg: 'failure to login!'}");
    }

    @RequestMapping(value = "/merchantLogin", method = RequestMethod.POST)
    public Object merchantlogin(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "name", required = true)String name,
                             @RequestParam(value = "passwd", required = true)String passwd){
        Merchant merchant = merchantRepository.findByUserName(name);
        if (merchant == null){
            return JSON.parse("{code: 400, msg: 'failure to login!'}");
        }
        if(merchant.getPassWd().equals(passwd)){
            request.getSession().setAttribute(merchant.getUserName(), merchant);
            return JSON.parse("{code: 200, msg: 'success!', id: " + merchant.getId() + "}");
        }
        return JSON.parse("{code: 400, msg: 'failure to login!'}");
    }
}
