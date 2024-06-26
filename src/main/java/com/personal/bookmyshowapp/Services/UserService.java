package com.personal.bookmyshowapp.Services;

import com.personal.bookmyshowapp.Models.User;
import com.personal.bookmyshowapp.Repositories.UserRepository;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User signUp(String email, String password) {
        //Validate if already exist
        Optional<User> userOptional = userRepository.findByEmail(email);
        if(userOptional.isPresent()) {
            throw new RuntimeException("User already exist!");
        }
        User user = new User();
        //Not working
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        user.setPassword(bCryptPasswordEncoder.encode(password));

        user.setPassword(password);
        user.setEmail(email);
        user.setBookings(new ArrayList<>());

        user = userRepository.save(user);

        return user;
    }

    public boolean logIn(String email, String password) {

        Optional<User> userOptional = userRepository.findByEmail(email);
        boolean flag=false;
        if(userOptional.isPresent() && userOptional.get().getPassword().equals(password)){
            flag=true;
            System.out.println("Login successful");
        }else {
            System.out.println("Login unsuccessful");
        }
        return flag;

    }

}
