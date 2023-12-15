package com.personal.bookmyshowapp.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpResponseDTO {
    private ResponseStatus responseStatus;
    private Long userId;
}
