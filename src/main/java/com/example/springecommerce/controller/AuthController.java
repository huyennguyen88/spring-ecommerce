package com.example.springecommerce.controller;

import com.example.springecommerce.exception.AlreadyExistException;
import com.example.springecommerce.exception.TransactionInternalException;
import com.example.springecommerce.form.users.UserRegisterForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@PropertySource("classpath:messages.properties")
@Controller
@Slf4j
public class AuthController extends BaseController {

    @Value("${msg_success_register}")
    private String msg_success_register;

    @Value("${msg_success_login}")
    private String msg_success_login;

    @GetMapping("/login-page")
    public String displayLogin() {
        return "auths/login";
    }

    @GetMapping("/login-success")
    public String loginSuccess(final RedirectAttributes redirectAttributes) {
        String css = "success";
        String msg = msg_success_login;
        log.info("Login success");
        return handleRedirect(redirectAttributes,css,msg,"/welcome");
    }

    @GetMapping("/register")
    public String displayRegister(Model model) {
        UserRegisterForm userForm = new UserRegisterForm();
        model.addAttribute("userForm", userForm);
        return "auths/register";
    }

    @PostMapping("/register-process")
    public String register(@Valid @ModelAttribute("userForm") UserRegisterForm userForm, BindingResult result,
                           final RedirectAttributes redirectAttributes) {
        String css = "error";
        if (result.hasErrors()) {
            return "auths/register";
        }
        try {
            userService.create(userForm);
        } catch (AlreadyExistException | TransactionInternalException e) {
            log.error(e.getMessage());
            return handleRedirect(redirectAttributes,css,e.getMessage(),"/register");
        }
        css = "success";
        return handleRedirect(redirectAttributes,css,msg_success_register,"/login-page");
    }
}
