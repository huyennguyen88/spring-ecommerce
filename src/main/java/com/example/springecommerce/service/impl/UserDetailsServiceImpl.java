//package com.example.springecommerce.service.impl;
//
//import com.example.springecommerce.entity.User;
//import com.example.springecommerce.security.MyUserDetails;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//public class UserDetailsServiceImpl extends BaseServiceImpl implements UserDetailsService {
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = getUserRepository().findByUsernameAndDeletedDateIsNull(username);
//        if(user==null) {
//            throw new UsernameNotFoundException("Could not find user, maybe not exist or deleted");
//        }
//        return new MyUserDetails(user);
//    }
//}
