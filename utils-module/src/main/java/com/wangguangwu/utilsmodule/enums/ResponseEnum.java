package com.wangguangwu.utilsmodule.enums;

import com.wangguangwu.utilsmodule.response.Response;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 响应 {@link  Response} 结果枚举，用于定义通用的响应状态和信息
 * <p>
 *
 * @author wangguangwu
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ResponseEnum {

    /**
     * 成功
     */
    SUCCESS(0, "成功"),

    /**
     * 失败
     */
    FAIL(-1, "失败"),

    /**
     * 业务层异常
     */
    SERVICE_UNKNOWN(1000, "业务层异常"),

    /**
     * 系统未知异常
     */
    SYSTEM_UNKNOWN(1001, "系统未知异常"),

    /**
     * 入参校验异常
     */
    METHOD_ARGUMENT_NOT_VALID(1002, "系统未知异常");

    /**
     * 状态码
     */
    private final int code;

    /**
     * 状态信息
     */
    private final String message;

}