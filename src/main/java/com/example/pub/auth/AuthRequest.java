package com.example.pub.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class AuthRequest {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public class AuthenticationRequest {
        private String username;
        private String password;
    }
}
