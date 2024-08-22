package com.wangguangwu.utilsmodule.builder;

import com.wangguangwu.utilsmodule.constant.HttpProtocolConstants;

/**
 * @author wangguangwu
 */
public final class UrlBuilder {

    private UrlBuilder() {
    }

    public static String url(String serverName, String urlSuffix) {
        return HttpProtocolConstants.HTTP_PROTOCOL + serverName + urlSuffix;
    }
}
