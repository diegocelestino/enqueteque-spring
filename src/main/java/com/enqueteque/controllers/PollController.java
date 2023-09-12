package com.enqueteque.controllers;

import com.enqueteque.dtos.PollCreateDto;
import com.enqueteque.dtos.PollDto;
import com.enqueteque.mappers.PollMapper;
import com.enqueteque.models.Poll;
import com.enqueteque.services.PollService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/poll")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class PollController {
    private final PollService pollService;
    private final PollMapper pollMapper;


    @GetMapping()
    public ResponseEntity<List<PollDto>> getAllPolls() {
        List<Poll> polls = pollService.getAllPolls();
        List<PollDto> pollsDto = pollMapper.to(polls);
        return ResponseEntity.ok(pollsDto);
    };

    @GetMapping("{pollId}")
    public ResponseEntity<PollDto> getPollById(@PathVariable UUID pollId) {
        Poll poll = pollService.getPollById(pollId);
        PollDto pollDto = pollMapper.to(poll);
        return ResponseEntity.ok(pollDto);
    };

    @PostMapping
    public ResponseEntity<PollDto> save(@RequestBody PollCreateDto pollCreateDto) {
        Poll poll = pollService.save(pollCreateDto);
        PollDto pollDto = pollMapper.to(poll);
        return ResponseEntity.ok(pollDto);
    }
}
