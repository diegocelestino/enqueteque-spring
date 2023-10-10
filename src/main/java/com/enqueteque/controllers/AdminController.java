package com.enqueteque.controllers;

import com.enqueteque.dtos.PollCreateFullDto;
import com.enqueteque.dtos.PollDto;
import com.enqueteque.dtos.PollFullDto;
import com.enqueteque.models.Poll;
import com.enqueteque.services.PollService;
import com.enqueteque.services.VoteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/admin")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class AdminController {
    private final PollService pollService;


    @GetMapping()
    public ResponseEntity<List<PollDto>> getAllPollsAdmin(){
        List<PollDto> pollsDto = pollService.getAllPollsAdmin();
        return ResponseEntity.ok(pollsDto);

    };

    @GetMapping({"{pollId}"})
    public ResponseEntity<PollFullDto> getPollById(@PathVariable UUID pollId){
        PollFullDto pollFullDto = pollService.getPollFullById(pollId);
        return ResponseEntity.ok(pollFullDto);

    };

    @PostMapping()
    public ResponseEntity<PollFullDto> saveFullPoll(@RequestBody PollCreateFullDto pollCreateFullDto) {
        PollFullDto pollFullDto = pollService.saveFullPoll(pollCreateFullDto);
        return ResponseEntity.ok(pollFullDto);
    }

    @PutMapping()
    public ResponseEntity<PollFullDto> updateFullPoll(@RequestBody PollFullDto pollFullDto) {
        PollFullDto updatedPollFullDto = pollService.updateFullPoll(pollFullDto);
        return ResponseEntity.ok(updatedPollFullDto);
    }


}
