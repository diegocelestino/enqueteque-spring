package com.enqueteque.mappers;

import com.enqueteque.dtos.PollDto;
import com.enqueteque.models.Poll;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    public List<PollDto> to(List<Poll> polls) {
        List<PollDto> pollsDto = new ArrayList<PollDto>();
        for (Poll poll:polls) {
            pollsDto.add(new PollDto(
                    poll.getId(),
                    poll.getTitle(),
                    poll.getCategory(),
                    poll.getCreateDate()
            ));
        }
        return pollsDto;
    }
}
