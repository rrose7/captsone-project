package com.vastika.training.capstone.suchanaapi.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LoginSuccessResponse {
    private int id;
    private String Username;
    private String token;
    private String role;
}
