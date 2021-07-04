package com.example.springecommerce.controller.authentication;

import com.example.springecommerce.form.users.UserRegisterForm;
import com.example.springecommerce.service.UserService;
import com.example.springecommerce.validation.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
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
public class AuthController {

    @Value("${msg_error_username_or_email}")
    private String msg_error_username_or_email;

    @Value("${msg_sucess_register}")
    private String msg_sucess_register;

    @Autowired
    private UserService userService;

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
        UserValidation userVali = new UserValidation();
        userVali.validate(userForm, result);
        if (result.hasErrors()) {
            return "auths/register";
        } else if(userService.isUsernameExist(userForm.getUsername()) || userService.isUsernameExist(userForm.getEmail())){
            model.addAttribute("error", msg_error_username_or_email);
            return "auths/register";
        } else
        userService.createUser(userInfo.convertToUser());
        redirectAttributes.addFlashAttribute("registersuccess", msg_sucess_register);
        logger.info(redirectAttributes.getAttribute("registersuccess"));
        return "redirect:/login-page";
    }
}
