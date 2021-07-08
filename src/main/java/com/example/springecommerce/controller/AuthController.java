package com.example.springecommerce.controller;

import com.example.springecommerce.dto.response.UserResponseResDto;
import com.example.springecommerce.form.users.UserRegisterForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class AuthController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Value("${msg_error_username}")
    private String msg_error_username;

    @Value("${msg_error_email}")
    private String msg_error_email;

    @Value("${msg_success_register}")
    private String msg_success_register;

    @Value("${msg_error_register}")
    private String msg_error_register;

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
        logger.info("Login success");
        return handleRedirect(redirectAttributes,css,msg,"/welcome");
    }

    @GetMapping("/register")
    public String displayRegister(Model model) {
        UserRegisterForm userForm = new UserRegisterForm();
        model.addAttribute("userForm", userForm);
        return "auths/register";
    }

    @PostMapping("/register-process")
    public String register(@Valid @ModelAttribute("userForm") UserRegisterForm userForm, BindingResult result, Model model,
                           final RedirectAttributes redirectAttributes) {
        String css = "error";
        String msg = msg_error_username;

        if (result.hasErrors()) {
            return "auths/register";
        } else if(userService.isUsernameExist(userForm.getUsername())) {
            return handleRedirect(redirectAttributes,css,msg,"/register");
        } else if (userService.isEmailExist(userForm.getEmail())) {
            msg = msg_error_email;
            return handleRedirect(redirectAttributes,css,msg,"/register");
        }
        UserResponseResDto resDto = userService.create(userForm.toUserEntity());
        if(resDto==null) {
            msg = msg_error_register;
            return handleRedirect(redirectAttributes,css,msg,"/register");
        }
        css = "success";
        msg = msg_success_register;
        return handleRedirect(redirectAttributes,css,msg,"/login-page");
    }
}
