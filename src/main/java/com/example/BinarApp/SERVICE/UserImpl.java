package com.example.BinarApp.SERVICE;

import com.example.BinarApp.ENTITY.User;
import com.example.BinarApp.MODEL.RESPONSE.UserResponse;
import com.example.BinarApp.REPOSITORY.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;



@Slf4j
@Service
public class UserImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public String register(String inputEmail, String inputUsername, String inputpassword) {

        User user =new User();
        user.setEmail(inputEmail);
        user.setUsername(inputUsername);
        user.setPassword(inputpassword);

        if (userRepository.existsByUsername(inputUsername) || userRepository.existsByEmail(inputEmail)){
            log.warn("Username/Email has already been used.");

            return "Username/Email telah di pakai";
        } else {
            userRepository.save(user);
            log.info("User registered: {}", user);

            return "Data Telah tersimpan Silahkan Login";
        }


    }

    @Override
    public User updateUser(User user) {
        Optional<User> userByID = userRepository.findById(user.getId());
        if (userByID.isPresent()) {
            User user1 = userByID.get();
            user1.setEmail(user.getEmail() != null ? user.getEmail() : user1.getEmail());
            user1.setUsername(user.getUsername() != null ? user.getUsername() : user1.getUsername());
            user1.setPassword(user.getPassword() != null ? user.getPassword() : user1.getPassword());
            userRepository.save(user1);
            log.info("User berhasil diupdate");
            return user1;
        } else {
            log.error("User tidak ditemukan");
            return  null;
        }

    }

    @Override
    public void deleteUser(Long user) {
        if (userRepository.existsById(user)){
            userRepository.deleteById(user);
            log.info("User Berhasil dihapus");

        }else{
            log.error("Username telah digunakan");

        }

    }

//    @Override
//    public UserResponse addUser(UserResponse userResponse) {
//        User user =new User();
//
//        user.setUsername(userResponse.getUsername());
//        user.setEmail(userResponse.getEmailAddress());
//        user.setPassword(userResponse.getPassword());
//        User savedUser = userRepository.save(user);
//
//        UserResponse savedUserRespon = new UserResponse();
//        savedUserRespon.setUsername(savedUser.getUsername());
//        savedUserRespon.setEmailAddress(savedUser.getEmail());
//        savedUserRespon.setPassword(savedUser.getPassword());
//        return savedUserRespon;
//    }


}
