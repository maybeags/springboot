package com.study.library.service;

import com.study.library.dto.OAuth2MergeReqDto;
import com.study.library.dto.OAuth2SignUpReqDto;
import com.study.library.dto.SignUpReqDto;
import com.study.library.dto.SigninReqDto;
import com.study.library.entity.OAuth2;
import com.study.library.entity.User;
import com.study.library.exception.SaveException;
import com.study.library.jwt.JwtProvider;
import com.study.library.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Service
public class AuthService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private JwtProvider jwtProvider;

    public boolean isDuplicatedUsername(String username) {

        return userMapper.findUserByUsername(username) != null;
    }

    @Transactional(rollbackFor = Exception.class)
    public void signup(SignUpReqDto signUpReqDto) {
        int successCount = 0;
        User user = signUpReqDto.toEntity(passwordEncoder);

        successCount += userMapper.saveUser(user);
        successCount += userMapper.saveRole(user.getUserId(), 1);

        if(successCount < 2) {
            throw new SaveException();
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void oAuth2signup(OAuth2SignUpReqDto oAuth2SignUpReqDto) {
        int successCount = 0;
        User user = oAuth2SignUpReqDto.toEntity(passwordEncoder);
        successCount += userMapper.saveUser(user);
        successCount += userMapper.saveRole(user.getUserId(), 1);
        successCount += userMapper.saveOAuth2(oAuth2SignUpReqDto.toOAuth2Entity(user.getUserId()));

        if(successCount < 3) {
            throw new SaveException();
        }
    }

    public String signin(SigninReqDto signinReqDto) {
        User user = userMapper.findUserByUsername(signinReqDto.getUsername());
        if (user == null) {
            throw new UsernameNotFoundException("사용자 정보를 확인하세요");
        }
        if (!passwordEncoder.matches(signinReqDto.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("사용자 정보를 확인하세요");
        }

        return jwtProvider.generateToken(user);
    }


    public void oAuth2Merge(OAuth2MergeReqDto oAuth2MergeReqDto) {
        User user = userMapper.findUserByUsername(oAuth2MergeReqDto.getUsername());

        if(user == null) {
            throw new UsernameNotFoundException("사용자 정보를 확인하세요");
        }
        if(!passwordEncoder.matches(oAuth2MergeReqDto.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("사용자 정보를 확인하세요");
        }
        OAuth2 oAuth2 = OAuth2.builder()
                .oAuth2Name(oAuth2MergeReqDto.getOauth2Name())
                .userId(user.getUserId())
                .providerName(oAuth2MergeReqDto.getProviderName())
                .build();

        userMapper.saveOAuth2(oAuth2);
    }
}
