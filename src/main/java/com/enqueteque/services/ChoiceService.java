package com.enqueteque.services;

import com.enqueteque.dtos.ChoiceCreateDto;
import com.enqueteque.dtos.ChoiceDto;
import com.enqueteque.models.Choice;
import com.enqueteque.models.Poll;
import com.enqueteque.repositories.ChoiceRepository;
import jakarta.xml.bind.DatatypeConverter;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Log4j2
public class ChoiceService {
    private final ChoiceRepository choiceRepository;

    public Choice save(ChoiceCreateDto choiceCreateDto, UUID pollId){
        return choiceRepository.save(new Choice(
                choiceCreateDto.getTitle(),
                DatatypeConverter.parseBase64Binary(choiceCreateDto.getImage()),
                pollId
        ));
    }

    public List<Choice> findAllByPollId(UUID pollId) {
        return choiceRepository.findAllByPollId(pollId);
    }

    public List<Choice> saveChoices(List<ChoiceCreateDto> choicesCreateDto, Poll poll) {
        List<Choice> choices = new ArrayList<>();
        for (ChoiceCreateDto choiceCreateDto : choicesCreateDto) {
            choices.add(choiceRepository.save(new Choice(
                    choiceCreateDto.getTitle(),
                    DatatypeConverter.parseBase64Binary(choiceCreateDto.getImage()),
                    poll.getId()
            )));
        }
        return choices;
    }

    public List<Choice> updateChoices(List<ChoiceDto> choicesDto, UUID pollId) {
        List<Choice> choices = new ArrayList<>();
        for (ChoiceDto choiceDto : choicesDto) {
            choices.add(choiceRepository.save(new Choice(
                    choiceDto.getId(),
                    choiceDto.getTitle(),
                    DatatypeConverter.parseBase64Binary(choiceDto.getImage()),
                    pollId
            )));
        }
        return choices;
    }
}
