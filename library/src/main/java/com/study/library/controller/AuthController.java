package com.study.library.controller;

import com.study.library.aop.annotation.ParamsPrintAspect;
import com.study.library.dto.SignUpReqDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @ParamsPrintAspect
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignUpReqDto signUpReqDto) {
        return ResponseEntity.ok(null);
    }
}
