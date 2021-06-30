package com.example.springecommerce.service.impl;

import com.example.springecommerce.dto.UserDTO;
import com.example.springecommerce.entity.User;
import com.example.springecommerce.form.UserForm;
import com.example.springecommerce.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

    public Optional<User> findById(int key) {
        try {
            return getUserRepository().findById(key);
        }catch (Exception e) {
            logger.error("Error find one user",e);
            return Optional.empty();
        }
    }

    @Override
    public List<UserDTO> findAll(Pageable pageable) {
        try {
            List<User> users = getUserRepository().findAll(pageable).getContent();
            List<UserDTO> userDTOList = new ArrayList<>();
            for (User u: users) {
                userDTOList.add(new UserDTO(u));
            }
            return userDTOList;
        } catch (Exception e) {
            logger.error("Error find all user",e);
            return Collections.emptyList();
        }
    }

    @Override
    public int getSize() {
        try {
            return (int) getUserRepository().count();
        } catch (Exception e) {
            return 0;
        }
    }

    private boolean isDeleted(User user) {
        return user.getDelete_time()!=null;
    }

    @Override
    public boolean delete(int id) {
        try {
            Optional<User> optionalUser = getUserRepository().findById(id);
            if(optionalUser.isPresent() && !isDeleted(optionalUser.get())) {
                User user = optionalUser.get();
                user.setDelete_time(LocalDateTime.now());
                getUserRepository().save(user);
                return true;
            }
            return false;
        } catch (Exception e) {
            logger.error("Error deleting user");
            throw (e);
        }
    }

    @Override
    public ResponseEntity<UserDTO> update(int user_id, UserForm.Update userForm) {
        Optional<User> optional = getUserRepository().findById(user_id);
        if(optional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try {
            User user = optional.get();
            user.setFullname(userForm.getFullname());
            user.setAddress(userForm.getAddress());
            user.setAvatar(userForm.getAvatar());
            user.setPhone(userForm.getPhone());
            User updatedUser = getUserRepository().save(user);
            UserDTO userDTO = new UserDTO(updatedUser);
            return new ResponseEntity<>(userDTO, HttpStatus.OK);

        } catch (Exception e) {
            logger.error("Error update user");
            throw (e);
        }
    }

}
