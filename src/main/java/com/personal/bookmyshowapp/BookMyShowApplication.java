package com.personal.bookmyshowapp;

import com.personal.bookmyshowapp.Controllers.UserController;
import com.personal.bookmyshowapp.DTOs.SignUpRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookMyShowApplication implements CommandLineRunner {
    @Autowired
    private UserController userController;

    @Override
    public void run(String... args) throws Exception {
        SignUpRequestDTO signUpRequestDTO = new SignUpRequestDTO();
        signUpRequestDTO.setEmail("pranmay30@scaler.com");
        signUpRequestDTO.setPassword("Shravani#02");
        userController.signUp(signUpRequestDTO);
        userController.logIn(signUpRequestDTO);
    }
    public static void main(String[] args) {
//        BaseModel bs = new BaseModel();
//        bs.getId();

        SpringApplication.run(BookMyShowApplication.class, args);
    }


}
