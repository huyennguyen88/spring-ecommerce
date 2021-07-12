package com.example.springecommerce.controller;

import com.example.springecommerce.service.CategoryDetailService;
import com.example.springecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class BaseController {
    @Autowired
    protected UserService userService;

    @Autowired
    protected CategoryDetailService categoryDetailService;

    protected String handleRedirect(final RedirectAttributes redirectAttributes, String css, String msg,
                                    String redirectEndpoint) {
        redirectAttributes.addFlashAttribute("css", css);
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:" + redirectEndpoint;
    }

}
