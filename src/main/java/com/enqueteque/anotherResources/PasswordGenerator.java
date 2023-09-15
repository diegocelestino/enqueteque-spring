package com.enqueteque.anotherResources;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.UUID;

public class PasswordGenerator {
    public static void main(String[] args) {

        UUID userId = UUID.randomUUID();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = encoder.encode("1234");

        System.out.println("UserId: " + userId);
        System.out.println("Password: " + password);
    }
}
