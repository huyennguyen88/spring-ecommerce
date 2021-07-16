package com.example.springecommerce.service.impl;

import com.example.springecommerce.dto.UserDTO;
import com.example.springecommerce.dto.response.UserResDto;
import com.example.springecommerce.entity.Role;
import com.example.springecommerce.entity.User;
import com.example.springecommerce.exception.AlreadyExistException;
import com.example.springecommerce.exception.TransactionInternalException;
import com.example.springecommerce.form.users.UserRegisterForm;
import com.example.springecommerce.service.UserService;
import com.example.springecommerce.utils.DateTimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
@Slf4j
public class UserServiceImpl extends BaseServiceImpl implements UserService {

    public UserResDto findById(int key) {
        UserResDto userResDto;
        try {
            Optional<User> optionalUser = getUserRepository().findById(key);
            if(optionalUser.isPresent()){
                User user = optionalUser.get();
                userResDto = getModelMapper().map(user, UserResDto.class);

                LocalDateTime date = userResDto.getCreatedDate();
                userResDto.setCreateDateString(DateTimeUtils.toDateTimeString(date));
                log.info("date: "+userResDto.getCreateDateString());
                return userResDto;
            }

        }catch (Exception e) {
            log.error("Error find one user",e);
            return null;
        }
        return null;
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
    public UserResDto create(UserRegisterForm userForm) throws AlreadyExistException, TransactionInternalException {
        if(isUsernameExist(userForm.getUsername())) {
            throw new AlreadyExistException("There is an account with that email address: "
                    + userForm.getUsername());
        }
        if(isEmailExist(userForm.getEmail())) {
            throw new AlreadyExistException("Email already existed: "+userForm.getEmail());
        }
        try {
            User user = getModelMapper().map(userForm, User.class);
            user.setEncryptedPassword(getPasswordEncoder().encode(userForm.getPassword()));
            user.setCreatedBy(user);
            user.setUpdatedBy(user);
            User newUser = getUserRepository().save(user);
            Role role = getRoleRepository().findByCode("USER");
            /* Add role */
            newUser.setRoles(Set.of(role));
            role.addUser(newUser);
            /* Save */
            getRoleRepository().save(role);
            newUser = getUserRepository().save(user);
            return getModelMapper().map(newUser, UserResDto.class);
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
