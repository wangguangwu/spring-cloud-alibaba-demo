package com.wangguangwu.usermodule.service.impl;

import com.wangguangwu.usermodule.entity.UserInfoDO;
import com.wangguangwu.usermodule.mapper.UserInfoMapper;
import com.wangguangwu.usermodule.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wangguangwu
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfoDO getUserById(Long userId) {
        return userInfoMapper.selectById(userId);
    }
}
