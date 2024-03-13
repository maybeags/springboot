package com.study.library.dto;

import lombok.Data;

@Data
public class SignUpReqDto {
    private String username;
    private String password;
    private String name;
    private String email;
}
