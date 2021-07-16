package com.example.springecommerce.controller;

import com.example.springecommerce.dto.response.UserResDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequestMapping("/users")
@Controller
public class UserController extends BaseController{

//    @GetMapping("/all")
//    public ResponseEntity<PageDTO> index(@RequestParam("page") int page, @RequestParam("size") int size) {
//        PageDTO pageDTO = new PageDTO();
//        pageDTO.setPage(page);
//        Pageable pageable = PageRequest.of(page-1, size, Sort.by("create_time").descending());
//        List<UserDTO> users = userService.findAll(pageable);
//        pageDTO.setListResult(users);
//        pageDTO.setTotalPage((int) Math.ceil((double) (userService.getSize()) / size));
//        return new ResponseEntity<>(pageDTO, HttpStatus.OK);
//    }

    @GetMapping("/{id}/show")
    public String show(@PathVariable("id") int id, Model model) {
        if(isRightPerson(id)) {
            return "redirect:/errors/access-denied";
        }
        UserResDto userResDto = userService.findById(id);
        model.addAttribute("user", userResDto);
        return "users/user";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        if(isRightPerson(id)) {
            return "redirect:/errors/access-denied";
        }
        UserResDto userResDto = userService.findById(id);
        model.addAttribute("user", userResDto);
        return "users/edit-form";
    }
//
//    @PutMapping("/{id}/update")
//    public String update(@PathVariable("id") int id, Model model, UserResDto user,
//                         BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
//
//
//    }
}
