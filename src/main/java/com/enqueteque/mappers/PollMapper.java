package com.enqueteque.mappers;

import com.enqueteque.dtos.PollDto;
import com.enqueteque.models.Poll;
import org.springframework.stereotype.Component;

@Component
public class PollMapper {
    public PollDto to(Poll poll) {
        return new PollDto(
                poll.getId(),
                poll.getTitle(),
                poll.getCategory(),
                poll.getCreateDate()
        );
    }
}
