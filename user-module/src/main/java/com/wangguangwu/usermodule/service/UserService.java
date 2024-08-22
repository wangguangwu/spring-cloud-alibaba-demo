package com.wangguangwu.usermodule.service;

import com.wangguangwu.beanmodule.bean.User;

/**
 * @author wangguangwu
 */
public interface UserService {

    /**
     * 根据id获取用户信息
     */
    User getUserById(Long userId);

}
