package com.wangguangwu.usermodule.service.impl;

import com.wangguangwu.usermodule.entity.UserInfoDO;
import com.wangguangwu.usermodule.mapper.UserInfoMapper;
import com.wangguangwu.usermodule.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author wangguangwu
 * @since 2024-08-21
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfoDO> implements UserInfoService {

}
