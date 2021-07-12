package com.example.springecommerce.controller;

import com.example.springecommerce.dto.response.CategoryResDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController extends BaseController {

    @GetMapping("/welcome")
    public String index(HttpSession session) {
        if(session.getAttribute("roots") == null) {
            List<CategoryResDto> category_roots = categoryDetailService.getRoots();
            session.setAttribute("roots", category_roots);
        }
        return "homes/home";
    }
}
