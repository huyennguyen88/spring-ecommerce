package com.example.springecommerce.controller.authentication;

import com.example.springecommerce.controller.BaseController;
import com.example.springecommerce.dto.response.UserResponseResDto;
import com.example.springecommerce.form.users.UserRegisterForm;
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

    @Value("${msg_error_username_or_email}")
    private String msg_error_username_or_email;

    @Value("${msg_sucess_register}")
    private String msg_sucess_register;

    @Value("${msg_error_register}")
    private String msg_error_register;

    @GetMapping("/login-page")
    public String displayLogin() {
        return "auths/login";
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
        String msg = msg_error_username_or_email;

        if (result.hasErrors()) {
            return "auths/register";
        } else if(userService.isUsernameExist(userForm.getUsername()) || userService.isUsernameExist(userForm.getEmail())){
            return handleRedirect(redirectAttributes,css,msg,"/register");
        }
        UserResponseResDto resDto = userService.create(userForm.toUserEntity());
        if(resDto==null) {
            msg = msg_error_register;
            return handleRedirect(redirectAttributes,css,msg,"/register");
        }
        css = "success";
        msg = msg_sucess_register;
        return handleRedirect(redirectAttributes,css,msg,"/login-page");
    }
}
