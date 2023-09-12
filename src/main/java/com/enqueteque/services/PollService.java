package com.enqueteque.services;

import com.enqueteque.dtos.PollCreateDto;
import com.enqueteque.models.Poll;
import com.enqueteque.repositories.PollRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Log4j2
public class PollService {
    private final PollRepository pollRepository;


    public Poll save(PollCreateDto pollCreateDto){
        Poll poll = new Poll(
                pollCreateDto.getTitle(),
                pollCreateDto.getCategory()
        );

        return pollRepository.save(poll);
    }

    public List<Poll> getAllPolls() {
        return this.pollRepository.findAll();
    }
}
