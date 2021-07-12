package com.example.springecommerce.service.impl;

import com.example.springecommerce.dto.UserDTO;
import com.example.springecommerce.dto.response.UserResponseResDto;
import com.example.springecommerce.entity.Role;
import com.example.springecommerce.entity.User;
import com.example.springecommerce.exception.AlreadyExistException;
import com.example.springecommerce.exception.TransactionInternalException;
import com.example.springecommerce.form.users.UserRegisterForm;
import com.example.springecommerce.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl extends BaseServiceImpl implements UserService {

    public Optional<User> findById(int key) {
        try {
            return getUserRepository().findById(key);
        }catch (Exception e) {
            log.error("Error find one user",e);
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
            log.error("Error find all user",e);
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
        return user.getDeletedDate()!=null;
    }

    @Override
    public boolean delete(int id) {
        try {
            Optional<User> optionalUser = getUserRepository().findById(id);
            if(optionalUser.isPresent() && !isDeleted(optionalUser.get())) {
                User user = optionalUser.get();
                user.setDeletedDate(LocalDateTime.now());
                getUserRepository().save(user);
                return true;
            }
            return false;
        } catch (Exception e) {
            log.error("Error deleting user");
            throw (e);
        }
    }

    private boolean isUsernameExist(String username) {
        try {
            User user = getUserRepository().findByUsername(username);
            return user!=null;
        } catch (Exception e) {
            log.error("Error checkin username exist: "+e);
        }
        return false;
    }

    private boolean isEmailExist(String email) {
        try {
            User user = getUserRepository().findByEmail(email);
            return user!=null;
        } catch (Exception e) {
            log.error("Error checkin email exist: "+e);
        }
        return false;
    }
    @Override
    public UserResponseResDto create(UserRegisterForm userForm) throws AlreadyExistException, TransactionInternalException {
        if(isUsernameExist(userForm.getUsername())) {
            throw new AlreadyExistException("There is an account with that email address: "
                    + userForm.getUsername());
        }
        if(isEmailExist(userForm.getEmail())) {
            throw new AlreadyExistException("Email already existed: "+userForm.getEmail());
        }
        try {
            User user = userForm.toUserEntity();
            user.setPassword(getPasswordEncoder().encode(user.getPassword()));
            User newUser = getUserRepository().save(user);
            Role role = getRoleRepository().findByCode("USER");
            /* Add role */
            newUser.setRoles(List.of(role));
            role.addUser(newUser);
            /* Save */
            getRoleRepository().save(role);
            newUser = getUserRepository().save(user);
            return new UserResponseResDto(newUser);
        } catch (Exception e) {
            log.error("Error create user: server internal exception: "+e);
            throw new TransactionInternalException("Error create user: server internal exception", e);
        }
    }


//    @Override
//    public ResponseEntity<UserDTO> update(int user_id, UserRegisterForm.Update userForm) {
//        Optional<User> optional = getUserRepository().findById(user_id);
//        if(optional.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        try {
//            User user = optional.get();
//            user.setFullname(userForm.getFullname());
//            user.setAddress(userForm.getAddress());
//            user.setAvatar(userForm.getAvatar());
//            user.setPhone(userForm.getPhone());
//            User updatedUser = getUserRepository().save(user);
//            UserDTO userDTO = new UserDTO(updatedUser);
//            return new ResponseEntity<>(userDTO, HttpStatus.OK);
//
//        } catch (Exception e) {
//            logger.error("Error update user");
//            throw (e);
//        }
//    }

}
