package com.wangguangwu.ordermodule.handler;


import com.wangguangwu.utilsmodule.enums.ResponseEnum;
import com.wangguangwu.utilsmodule.exception.ServiceException;
import com.wangguangwu.utilsmodule.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

/**
 * 定义全局异常处理
 * 该类用于捕获和处理应用程序中的异常，并返回统一的响应格式。
 *
 * @author wangguangwu
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理自定义的业务异常 ServiceException
     * 当业务逻辑抛出 ServiceException 时，捕获该异常并返回错误响应。
     *
     * @param exception 捕获的 ServiceException
     * @return 包含错误信息的响应对象
     */
    @ExceptionHandler(ServiceException.class)
    private Response<String> handleServiceException(ServiceException exception) {
        log.error("ServiceException occurred: {}", exception.getMessage(), exception);
        return Response.error(ResponseEnum.SERVICE_UNKNOWN.getCode(), exception.getMessage());
    }

    /**
     * 处理所有未捕获的通用异常
     * 捕获应用程序中未处理的其他异常，并返回通用错误响应。
     *
     * @param exception 捕获的通用异常
     * @return 包含错误信息的响应对象
     */
    @ExceptionHandler(Exception.class)
    public Response<String> handleGeneralException(Exception exception) {
        log.error("Unhandled exception occurred: {}", exception.getMessage(), exception);
        return Response.error(ResponseEnum.SYSTEM_UNKNOWN, exception.getMessage());
    }

    /**
     * 处理入参字段校验异常
     * 当业务逻辑抛出 MethodArgumentNotValidException 时，捕获该异常并返回错误响应。
     *
     * @param exception 捕获的 ServiceException
     * @return 包含错误信息的响应对象
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response<String> handleValidationException(MethodArgumentNotValidException exception) {
        log.error("ValidationException occurred: {}", exception.getMessage(), exception);
        String errorMessage = exception.getBindingResult().getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining("; "));
        return Response.error(ResponseEnum.METHOD_ARGUMENT_NOT_VALID.getCode(), errorMessage);
    }
}
