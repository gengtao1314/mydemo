package com.gtao.demo.first.controller;


import com.gtao.demo.first.entity.User;
import com.gtao.demo.first.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gtao
 * @since 2020-07-24
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("list")
    public List<User> list(){
        return userService.list();
    }

}
