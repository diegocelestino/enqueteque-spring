package com.enqueteque.services;

import com.enqueteque.dtos.ChoiceCreateDto;
import com.enqueteque.dtos.ChoiceDto;
import com.enqueteque.models.Choice;
import com.enqueteque.repositories.ChoiceRepository;
import jakarta.xml.bind.DatatypeConverter;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

@Service
@AllArgsConstructor
@Log4j2
public class ChoiceService {
    private final ChoiceRepository choiceRepository;

    public Choice save(ChoiceCreateDto choiceCreateDto){
        return choiceRepository.save(new Choice(
                choiceCreateDto.getTitle(),
                DatatypeConverter.parseBase64Binary(choiceCreateDto.getImage()),
                choiceCreateDto.getPollId()
        ));
    }
}
