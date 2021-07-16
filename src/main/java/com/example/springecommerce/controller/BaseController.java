package com.example.springecommerce.controller;

import com.example.springecommerce.security.MyUserDetails;
import com.example.springecommerce.service.CategoryDetailService;
import com.example.springecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    protected MyUserDetails getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken)
            return null;
        return (MyUserDetails) authentication.getPrincipal();
    }

    protected boolean isRightPerson(int destId) {
        MyUserDetails currentUser = getCurrentUser();
        return currentUser.getId() != destId;
    }
}
