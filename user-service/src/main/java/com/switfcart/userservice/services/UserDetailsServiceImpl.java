package com.switfcart.userservice.services;

import com.switfcart.userservice.dto.UserDataResponseDto;
import com.switfcart.userservice.models.MyUserDetails;
import com.switfcart.userservice.models.User;
import com.switfcart.userservice.repository.UserDao;
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new MyUserDetails(user);
    }

    public void saveUser(User user) throws Exception {
        if (userDao.findByUsername(user.getUsername()) != null) {
            throw new Exception("Username already exists");
        }
        userDao.save(user);
    }

    public List<UserDataResponseDto> getAllUsers() {

        List<User> users = userDao.findAll();
        List<UserDataResponseDto> userDataResponseDtos = new ArrayList<>();

        users.forEach(user -> {
            userDataResponseDtos.add(new UserDataResponseDto(user.getId(), user.getName(), user.getUsername(), user.getRole()));
        });

        return userDataResponseDtos;
    }
}
