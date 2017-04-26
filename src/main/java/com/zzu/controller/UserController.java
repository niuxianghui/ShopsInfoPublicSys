package com.zzu.controller;

import com.alibaba.fastjson.JSON;
import com.zzu.model.User;
import com.zzu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.awt.print.Pageable;
import java.sql.SQLSyntaxErrorException;
import java.util.List;

/**
 * Created by niuxianghui on 17/4/24.
 */
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserRepository repository;

    @RequestMapping("/getUserList")
    public List<User> getUserList(HttpServletResponse response,
                                  @RequestParam(value = "_page", required = true)int page,
                                  @RequestParam(value = "_limit", required = true)int limit) {
        PageRequest pageRequest = new PageRequest(page - 1, limit, null);
        Page usersPage = repository.findAll(pageRequest);
        List<User> users = usersPage.getContent();
        response.setHeader("X-Total-Count", String.valueOf(usersPage.getTotalElements()));
        return users;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PATCH)
    public Object patchUser(@PathVariable(value = "id", required = true)Long id,
                          @RequestBody String value) {
        User user = JSON.parseObject(value, User.class);
        user.setId(id);
        repository.save(user);
        return JSON.parse("{code: 200, msg: 'success'}");
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public Object deleteUser(@PathVariable(value = "id")Long id) {
        repository.delete(id);
        return JSON.parse("{code: 200, msg: 'success'}");
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public Object createUser(@RequestBody String value) {
        User user = JSON.parseObject(value, User.class);
        if (repository.findByName(user.getName()) == null){
            repository.save(user);
        }
        return JSON.parse("{code: 200, msg: 'success'}");
    }
}
