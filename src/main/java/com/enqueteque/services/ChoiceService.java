package com.enqueteque.services;

import com.enqueteque.dtos.ChoiceCreateDto;
import com.enqueteque.dtos.ChoiceDto;
import com.enqueteque.dtos.PollCreateDto;
import com.enqueteque.models.Choice;
import com.enqueteque.models.Poll;
import com.enqueteque.repositories.ChoiceRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Log4j2
public class ChoiceService {
    private final ChoiceRepository choiceRepository;

    public Choice save(ChoiceCreateDto choiceCreateDto){

        return choiceRepository.save(new Choice(
                choiceCreateDto.getTitle(),
                choiceCreateDto.getImage(),
                choiceCreateDto.getPollId()
        ));
    }
}
