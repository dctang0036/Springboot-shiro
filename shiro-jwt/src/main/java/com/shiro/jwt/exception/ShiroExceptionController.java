package com.shiro.jwt.exception;

import com.shiro.jwt.domain.ApiMessage;
import org.apache.shiro.ShiroException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ShiroExceptionController {
    // 捕捉shiro的异常
    @ExceptionHandler(ShiroException.class)
    public ApiMessage<String> handle401() {
        return new ApiMessage<>(false, "400", "","您没有权限访问" );
    }

    // 捕捉其他所有异常
    @ExceptionHandler(Exception.class)
    public ApiMessage<String> globalException(HttpServletRequest request, Throwable ex) {
        ex.printStackTrace();
        return new ApiMessage<>(false, "400", "","访问出错，无法访问: " + ex.getMessage() );
    }
}
