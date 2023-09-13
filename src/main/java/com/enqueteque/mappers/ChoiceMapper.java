package com.enqueteque.mappers;

import com.enqueteque.dtos.ChoiceDto;
import com.enqueteque.dtos.PollDto;
import com.enqueteque.models.Choice;
import com.enqueteque.models.Poll;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@Component
public class ChoiceMapper {
    public ChoiceDto to(Choice choice, Integer votes) {
        return new ChoiceDto(
                choice.getId(),
                choice.getTitle(),
                Base64.getEncoder().withoutPadding().encodeToString(choice.getImage()),
                choice.getPollId(),
                votes
        );
    }
}
