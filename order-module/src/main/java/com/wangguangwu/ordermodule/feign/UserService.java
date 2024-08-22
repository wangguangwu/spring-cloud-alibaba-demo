package com.wangguangwu.ordermodule.feign;

import com.wangguangwu.beanmodule.bean.User;
import com.wangguangwu.utilsmodule.constant.ServiceConstants;
import com.wangguangwu.utilsmodule.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wangguangwu
 */
@FeignClient(ServiceConstants.USER_SERVER)
public interface UserService {

    /**
     * 查询用户信息
     *
     * @param uid 用户id
     * @return 用户信息
     */
    @GetMapping(value = "/user/get/{uid}")
    Response<User> getUser(@PathVariable("uid") Long uid);

}
