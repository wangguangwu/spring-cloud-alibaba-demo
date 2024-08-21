package com.wangguangwu.usermodule.service;

import com.wangguangwu.usermodule.entity.UserInfoDO;

/**
 * @author wangguangwu
 */
public interface UserService {

    /**
     * 根据id获取用户信息
     */
    UserInfoDO getUserById(Long userId);

}
