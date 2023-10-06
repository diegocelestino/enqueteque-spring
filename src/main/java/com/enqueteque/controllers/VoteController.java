package com.enqueteque.controllers;

import com.enqueteque.services.VoteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/vote")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class VoteController {
    private final VoteService voteService;

    @PostMapping("{choiceId}")
    public ResponseEntity<Map<String, String>> create(@PathVariable UUID choiceId){
        voteService.save(choiceId);
        Map<String, String> response = new HashMap<String, String>();
        response.put("status", "ok");
        return ResponseEntity.ok(response);
    }
}
