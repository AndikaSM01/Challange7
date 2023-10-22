package SERVICE;

import com.example.BinarApp.SERVICE.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserImplTest {
    @Autowired
    UserService userService;
   // @Test
//    public void Register_Test(){
//        User user = new User();
//        user.setUsername("Test");
//        user.setPassword("Test");
//        user.setEmail("Test@gmail.com");
//        user= UserRepository.save(user);
//        Assertions.assertEquals(UserRepository.findOne(user.getId()));
//    }
}
