package com.jwt.constant;

import com.jwt.utils.Result;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ShiroExceptionController {

    // 捕捉shiro的异常
    @ExceptionHandler(ShiroException.class)
    public Result handle401(Exception e) {
        if (e instanceof UnauthorizedException) {
            return Result.error("您没有权限访问");
        }
        return null;
    }

    @ExceptionHandler(BindException.class)
    public Result handleBindException(BindException ex) {
        // ex.getFieldError():随机返回一个对象属性的异常信息。如果要一次性返回所有对象属性异常信息，则调用ex.getAllErrors()
        FieldError fieldError = ex.getFieldError();
        StringBuilder sb = new StringBuilder();
        sb.append(fieldError.getField()).append("=[").append(fieldError.getRejectedValue()).append("]")
                .append(fieldError.getDefaultMessage());
        // 生成返回结果
        Result errorResult = new Result();
        errorResult.setCode(400);
        errorResult.setMessage(sb.toString());
        return errorResult;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleBindException(HttpServletRequest request, MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        List<String> msgList = new ArrayList<>();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            msgList.add(fieldError.getDefaultMessage());
        }

        String msg = String.join(",", msgList);
        return Result.error(msg);
    }

    // 捕捉其他所有异常
    @ExceptionHandler(Exception.class)
    public String globalException(HttpServletRequest request, Throwable ex) {
        ex.printStackTrace();
        return "访问出错，无法访问: " ;
    }
}
