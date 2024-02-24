package com.ecommerce.swiftcart.services;

import com.ecommerce.swiftcart.models.MyUserDetails;
import com.ecommerce.swiftcart.models.User;
import com.ecommerce.swiftcart.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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
}
