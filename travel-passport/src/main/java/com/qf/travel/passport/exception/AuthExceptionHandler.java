package com.qf.travel.passport.exception;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 权限不足处理器
 */

@ControllerAdvice
public class AuthExceptionHandler {

    @ExceptionHandler({UnauthorizedException.class})
    public String processPermission(UnauthorizedException e, Model model) {
        model.addAttribute("error",e);
        return "error";
    }

}
