package com.example.springecommerce.controller;

import com.example.springecommerce.constants.ErrorType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@PropertySource("classpath:messages.properties")
@RequestMapping("/errors")
public class ErrorController {

    @Value("${msg_error_access}")
    private String msg_error_access;

    @GetMapping("/access-denied")
    public String accessDenied(HttpServletRequest request, Model model) {
        String referer = request.getHeader("Referer");
        String code = ErrorType.ACCESS_DENIED.code;
        model.addAttribute("referer",referer);
        model.addAttribute("code",code);
        model.addAttribute("message",msg_error_access);
        return "errors/error";
    }
}
