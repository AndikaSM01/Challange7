package com.example.BinarApp.CONTROLLER;


import com.example.BinarApp.ENTITY.User;
import com.example.BinarApp.MODEL.RESPONSE.UserRegisterResponse;
import com.example.BinarApp.MODEL.RESPONSE.UserResponse;
import com.example.BinarApp.REPOSITORY.UserRepository;
import com.example.BinarApp.SERVICE.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/Api/BinarFud/users")
public class UserController {
@Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<String>Register(@RequestBody UserRegisterResponse userRegisterResponse) {
    String respon = userService.register(userRegisterResponse.getEmail(), userRegisterResponse.getUserName(), userRegisterResponse.getPassword());
    return ResponseEntity.status(HttpStatus.OK).body(respon);
    }
    @PutMapping
    public ResponseEntity<User>UpdateUser(@RequestBody User user) {
      User Respon = userService.updateUser(user);
      return ResponseEntity.status(HttpStatus.OK).body(Respon);
    }
    @DeleteMapping(path = "/{userid}")
    public ResponseEntity<String> deleteUser(@PathVariable("userid")Long id){
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body("Succes delete data");
    }

}
