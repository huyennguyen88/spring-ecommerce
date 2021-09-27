package com.example.springecommerce.controller;

import com.example.springecommerce.dto.response.CategoryResDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
public class HomeController extends BaseController {

    @GetMapping("/welcome")
    public String index(HttpSession session) {
        Object category_roots = session.getAttribute("roots");
        if(category_roots==null) {
            category_roots = categoryDetailService.getRoots();
            session.setAttribute("roots", category_roots);
        }
        return "homes/home";
    }
}
