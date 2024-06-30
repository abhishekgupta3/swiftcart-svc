package com.switfcart.userservice.services;

import com.switfcart.userservice.controller.AuthController;
import com.switfcart.userservice.dto.UserDataResponseDto;
import com.switfcart.userservice.models.MyUserDetails;
import com.switfcart.userservice.models.User;
import com.switfcart.userservice.repository.UserDao;
import com.switfcart.userservice.utils.JwtUtilsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserDao userDao;

    Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        logger.info("FIND USER BY USERNAME");
        if (user == null) {
            logger.error("COULDN'T FIND USER BY USERNAME " + username);
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new MyUserDetails(user);
    }

    public void saveUser(User user) throws Exception {
        logger.info("SAVE USER " + user);
        if (userDao.findByUsername(user.getUsername()) != null) {
            logger.error("Username already exists");
            throw new Exception("Username already exists");
        }
        userDao.save(user);
        logger.info("Saving User");
    }

    public List<UserDataResponseDto> getAllUsers() {
        logger.info("Get all Users");

        List<User> users = userDao.findAll();
        List<UserDataResponseDto> userDataResponseDtos = new ArrayList<>();

        users.forEach(user -> {
            userDataResponseDtos.add(new UserDataResponseDto(user.getId(), user.getName(), user.getUsername(), user.getRole()));
        });

        return userDataResponseDtos;
    }

    public User getUserByUsername(String username) {
        User user = userDao.findByUsername(username);
        if (user == null) {
            logger.error("No user found");
            throw new UsernameNotFoundException("Not logged in");
        }
        return user;
    }
}
