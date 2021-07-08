package com.example.springecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/helpers/")
public class HelperController {
    @GetMapping("/go-back")
    public String goBack(HttpServletRequest request) {
        String goBackUrl = request.getHeader("Referer");
        return "redirect:"+ goBackUrl;
    }
}
