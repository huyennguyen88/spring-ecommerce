package com.example.springecommerce.controller;

import com.example.springecommerce.dto.response.CategoryResDto;
import com.example.springecommerce.service.CategoryDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private CategoryDetailService categoryDetailService;

    @GetMapping("/welcome")
    public String index(HttpSession session) {
        if(session.getAttribute("roots") == null) {
            List<CategoryResDto> category_roots = categoryDetailService.getRoots();
            session.setAttribute("roots", category_roots);
        }
        return "homes/home";
    }
}
