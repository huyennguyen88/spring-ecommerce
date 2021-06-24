package com.example.springecommerce.api;

import com.example.springecommerce.dto.PageDTO;
import com.example.springecommerce.dto.UserDTO;
import com.example.springecommerce.entity.User;
import com.example.springecommerce.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.ehcache.shadow.org.terracotta.offheapstore.paging.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v2/users")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "Get all User",response = PageDTO.class)
    @GetMapping("/all")
    public ResponseEntity<PageDTO> index(@RequestParam("page") int page, @RequestParam("size") int size) {
        PageDTO pageDTO = new PageDTO();
        pageDTO.setPage(page);
        Pageable pageable = PageRequest.of(page-1, size, Sort.by("username"));
        List<UserDTO> users = userService.findAll(pageable);
        pageDTO.setListResult(users);
        pageDTO.setTotalPage((int) Math.ceil((double) (userService.getSize()) / size));
        return new ResponseEntity<>(pageDTO, HttpStatus.OK);
    }
    @ApiOperation(value = "Get one User by id", response = UserDTO.class)
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

}
