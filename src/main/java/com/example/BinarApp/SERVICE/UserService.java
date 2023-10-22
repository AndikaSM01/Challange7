package com.example.BinarApp.SERVICE;

import com.example.BinarApp.ENTITY.User;
import com.example.BinarApp.MODEL.RESPONSE.UserResponse;
import com.example.BinarApp.REPOSITORY.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserService {

    String register(String inputEmail, String inputUsername, String inputpassword);

    User updateUser(User user);

    void deleteUser(Long user);
//    UserResponse addUser(UserResponse userResponse);


}

