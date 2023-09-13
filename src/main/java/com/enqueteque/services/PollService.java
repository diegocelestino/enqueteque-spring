package com.enqueteque.services;

import com.enqueteque.dtos.PollCreateDto;
import com.enqueteque.models.Poll;
import com.enqueteque.repositories.PollRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import com.enqueteque.exceptions.*;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Log4j2
public class PollService {
    private final PollRepository pollRepository;

    public Poll save(PollCreateDto pollCreateDto){
        return pollRepository.save(new Poll(
                pollCreateDto.getTitle(),
                pollCreateDto.getCategory()
        ));
    }

    public List<Poll> getAllPolls() {
        return this.pollRepository.findAll();
    }

    public List<Poll> getAllPollsByCategory(String category) {
        return this.pollRepository.findAllByCategory(category);
    }

    public List<String> getAllCategories() {
        return pollRepository.findAllCategories();
    }

    public Poll getPollById(UUID pollId) {
        return pollRepository.findById(pollId)
                .orElseThrow(() -> new ResourceNotFoundException(ResourceName.POLL, pollId));
    }



}
