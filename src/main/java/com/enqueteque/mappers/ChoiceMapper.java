package com.enqueteque.mappers;

import com.enqueteque.dtos.ChoiceDto;
import com.enqueteque.dtos.PollDto;
import com.enqueteque.models.Choice;
import com.enqueteque.models.Poll;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChoiceMapper {
    public ChoiceDto to(Choice choice) {
        return new ChoiceDto(
                choice.getId(),
                choice.getTitle(),
                choice.getImage(),
                choice.getPollId()
        );
    }
}
