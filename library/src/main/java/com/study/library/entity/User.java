package com.study.library.entity;

import com.study.library.security.PrincipalUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private int userId;
    private String username;
    private String password;
    private String name;
    private String email;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    private List<RoleRegister> roleRegisters;

    public List<SimpleGrantedAuthority> getAuthorities() {


        return roleRegisters.stream()
                .map(roleRegister ->
                        new SimpleGrantedAuthority(roleRegister.getRole().getRoleName()))
                .collect(Collectors.toList());
    }

    public PrincipalUser toPrincipalUser() {


        return PrincipalUser.builder()
                .userId(userId)
                .username(username)
                .name(name)
                .email(email)
                .authorities(getAuthorities())
                .build();
    }
}
