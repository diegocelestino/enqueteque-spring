package com.enqueteque.services;

import com.enqueteque.dtos.*;
import com.enqueteque.mappers.ChoiceMapper;
import com.enqueteque.mappers.PollMapper;
import com.enqueteque.models.Choice;
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
    private final ChoiceService choiceService;
    private final PollMapper pollMapper;
    private final ChoiceMapper choiceMapper;

    public PollFullDto saveFullPoll(PollCreateFullDto pollCreateFullDto) {
        Poll poll = save(pollCreateFullDto.getPollCreateDto());
        Choice choice1 = choiceService.save(pollCreateFullDto.getChoices().get(0), poll.getId());
        Choice choice2 = choiceService.save(pollCreateFullDto.getChoices().get(1), poll.getId());

        PollDto pollDto = pollMapper.to(poll);
        ChoiceDto choiceDto1 = choiceMapper.to(choice1);
        ChoiceDto choiceDto2 = choiceMapper.to(choice2);

        return new PollFullDto(pollDto, List.of(choiceDto1, choiceDto2));
    }

    public PollFullDto getLatestPoll() {
        Poll poll = pollRepository.findLatest();
        List<Choice> choices = choiceService.findAllByPollId(poll.getId());

        PollDto pollDto = pollMapper.to(poll);
        ChoiceDto choiceDto1 = choiceMapper.to(choices.get(0));
        ChoiceDto choiceDto2 = choiceMapper.to(choices.get(1));

        return new PollFullDto(pollDto, List.of(choiceDto1, choiceDto2));
    }

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
