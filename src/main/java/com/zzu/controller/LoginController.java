package com.zzu.controller;

import com.zzu.model.User;
import com.zzu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "name", required = true)String name,
                        @RequestParam(value = "passwd", required = true)String passwd){
        User user = userRepository.findByUserName(name);
        if (user == null){
            return "nouser";
        }
        if(user.getPassWd().equals(passwd)){
            request.getSession().setAttribute(user.getUserName(), user);
            return "success";
        }
        return "nouser";
    }
}
