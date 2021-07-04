package com.example.springecommerce.controller;

import com.example.springecommerce.dto.PageDTO;
import com.example.springecommerce.dto.UserDTO;
import com.example.springecommerce.entity.User;
import com.example.springecommerce.form.users.UserRegisterForm;
import com.example.springecommerce.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<PageDTO> index(@RequestParam("page") int page, @RequestParam("size") int size) {
        PageDTO pageDTO = new PageDTO();
        pageDTO.setPage(page);
        Pageable pageable = PageRequest.of(page-1, size, Sort.by("create_time").descending());
        List<UserDTO> users = userService.findAll(pageable);
        pageDTO.setListResult(users);
        pageDTO.setTotalPage((int) Math.ceil((double) (userService.getSize()) / size));
        return new ResponseEntity<>(pageDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> show(@PathVariable int id) {
        Optional<User> optionalUser = userService.findById(id);
        if(optionalUser.isPresent()) {
            User user = optionalUser.get();
            UserDTO userDTO = new UserDTO(user);
            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        }
        return new ResponseEntity<> (HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}/delete")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        Optional<User> optionalUser = userService.findById(id);
        if(!optionalUser.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if(userService.delete(id)) {
            return new ResponseEntity<>("Success delete user",HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

//    @PutMapping("/{id}/edit")
//    public ResponseEntity<UserDTO> update(@PathVariable(value = "id") int user_id, @Valid @RequestBody UserRegisterForm.Update form) {
//        ResponseEntity<UserDTO> responseEntity = userService.update(user_id, form);
//        return responseEntity;
//    }
}
