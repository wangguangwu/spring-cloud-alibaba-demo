package com.wangguangwu.utilsmodule.builder;

import com.wangguangwu.utilsmodule.constant.ServiceConstants;

/**
 * @author wangguangwu
 */
public class UserUrlBuilder {

    private UserUrlBuilder() {
    }

    public static String query(Long userId) {
        return UrlBuilder.url(ServiceConstants.USER_SERVER, "/user/get/" + userId);
    }
}
