package com.example.springecommerce.service.impl;

import com.example.springecommerce.dto.UserDTO;
import com.example.springecommerce.entity.User;
import com.example.springecommerce.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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

}
