package com.study.library.controller;

import com.study.library.aop.annotation.ParamsPrintAspect;
import com.study.library.aop.annotation.ValidAspect;
import com.study.library.dto.OAuth2MergeReqDto;
import com.study.library.dto.OAuth2SignUpReqDto;
import com.study.library.dto.SignUpReqDto;
import com.study.library.dto.SigninReqDto;
import com.study.library.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @ValidAspect
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody SignUpReqDto signUpReqDto, BindingResult bindingResult) {
//        if(authService.isDuplicatedUsername(signUpReqDto.getUsername())) {
//            ObjectError objectError = new FieldError("username", "username", "이미 존재하는 사용자 이름입니다.");
//            bindingResult.addError(objectError);
//        }
        authService.signup(signUpReqDto);
        return ResponseEntity.created(null).body(true);
    }

    @ValidAspect
    @ParamsPrintAspect
    @PostMapping("/oauth2/signup")
    public ResponseEntity<?> oAuth2Signup(@Valid @RequestBody OAuth2SignUpReqDto oAuth2SignUpReqDto, BindingResult bindingResult) {
        authService.oAuth2signup(oAuth2SignUpReqDto);
        return ResponseEntity.created(null).body(true);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody SigninReqDto signinReqDto) {

        return ResponseEntity.ok(authService.signin(signinReqDto));
    }

    @PostMapping("/oauth2/merge")
    public ResponseEntity<?> oAuth2Merge(@RequestBody OAuth2MergeReqDto oAuth2MergeReqDto) {
        authService.oAuth2Merge(oAuth2MergeReqDto);
        return ResponseEntity.ok(true);
    }


//    @GetMapping("/principal")
//    public ResponseEntity<?> authenticated() {
//        return ResponseEntity.ok(null);
//    }
}
