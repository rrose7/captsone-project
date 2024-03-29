package com.vastika.training.capstone.suchanaapi.models.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Data
public class LoginRequest {
    @NotBlank
    @Size(min = 3 ,max = 40)
    private String Username;
    @NotBlank
    @Size(min= 3, max =40)
    private String password;
}
