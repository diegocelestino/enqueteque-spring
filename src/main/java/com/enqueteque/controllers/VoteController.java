package com.enqueteque.controllers;

import com.enqueteque.services.VoteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/vote")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class VoteController {
    private final VoteService voteService;

    @PostMapping("{choiceId}")
    public ResponseEntity<String> create(@PathVariable UUID choiceId){
        voteService.save(choiceId);
        return ResponseEntity.status(HttpStatus.CREATED).body("ok");
    }
}
