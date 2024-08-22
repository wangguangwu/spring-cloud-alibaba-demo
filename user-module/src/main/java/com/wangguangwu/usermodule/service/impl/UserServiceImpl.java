package com.wangguangwu.usermodule.service.impl;

import com.wangguangwu.beanmodule.bean.User;
import com.wangguangwu.usermodule.mapper.UserInfoMapper;
import com.wangguangwu.usermodule.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author wangguangwu
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public User getUserById(Long userId) {
        return Optional.ofNullable(userInfoMapper.selectById(userId))
                .map(userInfoDO -> {
                    User user = new User();
                    BeanUtils.copyProperties(userInfoDO, user);
                    return user;
                }).orElse(null);
    }
}
