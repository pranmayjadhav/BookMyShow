package com.personal.bookmyshowapp.Controllers;

import com.personal.bookmyshowapp.DTOs.ResponseStatus;
import com.personal.bookmyshowapp.DTOs.SignUpRequestDTO;
import com.personal.bookmyshowapp.DTOs.SignUpResponseDTO;
import com.personal.bookmyshowapp.Models.User;
import com.personal.bookmyshowapp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public SignUpResponseDTO signUp(SignUpRequestDTO signUpRequestDTO) {
        SignUpResponseDTO response = new SignUpResponseDTO();
        try {
            User user = userService.signUp(
                    signUpRequestDTO.getEmail(),
                    signUpRequestDTO.getPassword()
            );
            response.setResponseStatus(ResponseStatus.SUCCESS);
            response.setUserId(user.getId());
        }
        catch (Exception e) {
            response.setResponseStatus(ResponseStatus.FALURE);
        }
        return response;
    }

    public SignUpResponseDTO logIn(SignUpRequestDTO signUpRequestDTO) {
        SignUpResponseDTO response = new SignUpResponseDTO();
        try {
            boolean user = userService.logIn(
                    signUpRequestDTO.getEmail(),
                    signUpRequestDTO.getPassword()
            );
            response.setResponseStatus(ResponseStatus.SUCCESS);
        }
        catch (Exception e) {
            response.setResponseStatus(ResponseStatus.FALURE);
        }
        return response;
    }
}
