package com.example.springecommerce.controller;

import com.example.springecommerce.entity.Category;
import com.example.springecommerce.service.CategoryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {
    private static final Logger logger = Logger.getLogger(HomeController.class);

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/welcome")
    public String index(Model model, HttpSession session) {
        List<Category> category_roots = categoryService.getRoots();
        session.setAttribute("roots", category_roots);
        return "homes/home";
    }
}
