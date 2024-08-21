package com.wangguangwu.usermodule.controller;

import com.alibaba.fastjson2.JSON;
import com.wangguangwu.usermodule.entity.UserInfoDO;
import com.wangguangwu.usermodule.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wangguangwu
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping(value = "/get/{uid}")
    public UserInfoDO getUser(@PathVariable("uid") Long uid) {
        UserInfoDO user = userService.getUserById(uid);
        log.info("获取到的用户信息为：{}", JSON.toJSONString(user));
        return user;
    }
}
