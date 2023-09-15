package com.enqueteque.services;

import com.enqueteque.dtos.JwtAuthenticationResponse;
import com.enqueteque.dtos.SignInRequest;
import com.enqueteque.dtos.SignUpRequest;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SignInRequest request);
}