package com.example.BinarApp.SERVICE;

import com.example.BinarApp.MODEL.User;
import com.example.BinarApp.REPOSITORY.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(UserImpl.class);
    @Override
    public String register(String inputEmail, String inputUsername, String inputpassword) {

        User user =new User();
        user.setEmail(inputEmail);
        user.setUsername(inputUsername);
        user.setPassword(inputpassword);
        if (userRepository.existsByUsername(inputUsername) || userRepository.existsByEmail(inputEmail)){
            logger.warn("Username/Email has already been used.");

            return "Username/Email telah di pakai";
        } else {
            userRepository.save(user);
            logger.info("User registered: {}", user);

            return "Data Telah tersimpan Silahkan Login";
        }


    }
}
