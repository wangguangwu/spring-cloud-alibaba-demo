package com.wangguangwu.ordermodule.feign.fallback;

import com.wangguangwu.ordermodule.feign.UserService;
import com.wangguangwu.utilsmodule.response.Response;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author wangguangwu
 */
@Component
public class UserServiceFallBackFactory implements FallbackFactory<UserService> {

    @Override
    public UserService create(Throwable cause) {
        return uid -> Response.error("查询失败，触发容错机制");
    }
}
