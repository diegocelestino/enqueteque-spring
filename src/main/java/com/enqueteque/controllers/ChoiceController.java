package com.enqueteque.controllers;

import com.enqueteque.dtos.ChoiceCreateDto;
import com.enqueteque.dtos.ChoiceDto;
import com.enqueteque.mappers.ChoiceMapper;
import com.enqueteque.models.Choice;
import com.enqueteque.services.ChoiceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

@RestController
@RequestMapping("api/v1/choice")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class ChoiceController {
    private final ChoiceService choiceService;
    private final ChoiceMapper choiceMapper;

    @PostMapping
    public ResponseEntity<ChoiceDto> save(@RequestBody ChoiceCreateDto choiceCreateDto) {
        System.out.println("Chegou no mapper");
        Choice choice = choiceService.save(choiceCreateDto);
        ChoiceDto choiceDto = choiceMapper.to(choice);
        return ResponseEntity.ok(choiceDto);
    }
}
