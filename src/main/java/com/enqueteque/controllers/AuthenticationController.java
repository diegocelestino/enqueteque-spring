package com.enqueteque.controllers;


import com.enqueteque.dtos.JwtAuthenticationResponse;
import com.enqueteque.dtos.SignInRequest;
import com.enqueteque.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SignInRequest request) {
        return ResponseEntity.ok(authenticationService.signin(request));
    }
}
