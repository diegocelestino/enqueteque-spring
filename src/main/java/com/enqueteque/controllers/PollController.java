package com.enqueteque.controllers;

import com.enqueteque.dtos.PollCreateFullDto;
import com.enqueteque.dtos.PollDto;
import com.enqueteque.dtos.PollFullDto;
import com.enqueteque.dtos.PollPageDto;
import com.enqueteque.mappers.PollMapper;
import com.enqueteque.models.Poll;
import com.enqueteque.services.PollService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/poll")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class PollController {
    private final PollService pollService;

    @GetMapping("/latest")
    public ResponseEntity<PollFullDto> getLatestPoll() {
        PollFullDto pollFullDto = pollService.getLatestPoll();
        return ResponseEntity.ok(pollFullDto);
    };

    @GetMapping("/others")
    public ResponseEntity<List<PollDto>> getOthersPolls() {
        List<PollDto> pollsDto = pollService.getOthersPolls();
        return ResponseEntity.ok(pollsDto);
    };

    @PostMapping()
    public ResponseEntity<PollFullDto> saveFullPoll(@RequestBody PollCreateFullDto pollCreateFullDto) {
        PollFullDto pollFullDto = pollService.saveFullPoll(pollCreateFullDto);
        return ResponseEntity.ok(pollFullDto);
    }



    @GetMapping()
    public ResponseEntity<PollPageDto> getAllPolls(@PageableDefault(page = 0, size = 15) Pageable pageable) {
        PollPageDto pollsDto = pollService.getAllPollsPage(pageable);
        return ResponseEntity.ok(pollsDto);
    };


    @GetMapping("{pollId}")
    public ResponseEntity<PollFullDto> getPollById(@PathVariable UUID pollId) {
        PollFullDto pollFullDto = pollService.getPollFullById(pollId);
        return ResponseEntity.ok(pollFullDto);
    };

    @GetMapping("/category/{category}")
    public ResponseEntity<PollPageDto>getAllPollsByCategory(@PathVariable String category) {
        PollPageDto pollsDto = pollService.getAllPollsByCategory(category);
        return ResponseEntity.ok(pollsDto);
    };

    @GetMapping("/category/all")
    public ResponseEntity<List<String>> getAllCategories() {
        List<String> categories = pollService.getAllCategories();
        return ResponseEntity.ok(categories);
    };
}
