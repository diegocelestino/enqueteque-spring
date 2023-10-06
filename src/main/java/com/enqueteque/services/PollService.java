package com.enqueteque.services;

import com.enqueteque.dtos.*;
import com.enqueteque.mappers.ChoiceMapper;
import com.enqueteque.mappers.PollMapper;
import com.enqueteque.models.Choice;
import com.enqueteque.models.Poll;
import com.enqueteque.models.PollComparator;
import com.enqueteque.repositories.PollRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.cglib.core.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.enqueteque.exceptions.*;

import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Log4j2
public class PollService {
    private final PollRepository pollRepository;
    private ChoiceService choiceService;
    private final VoteService voteService;
    private final PollMapper pollMapper;
    private final ChoiceMapper choiceMapper;

    public PollFullDto saveFullPoll(PollCreateFullDto pollCreateFullDto) {
        Poll poll = save(pollCreateFullDto.getPollCreateDto());
        List<Choice> choices = choiceService.saveChoices(pollCreateFullDto.getChoices(), poll);
        List<ChoiceDto> choicesDto = buildChoicesDto(choices);
        PollDto pollDto = pollMapper.to(poll);
        return new PollFullDto(pollDto, choicesDto);
    }

    public PollFullDto getLatestPoll() {
        Poll poll = pollRepository.findLatest();
        List<Choice> choices = getChoicesByPollId(poll);
        List<ChoiceDto> choicesDto = buildChoicesDto(choices);
        PollDto pollDto = pollMapper.to(poll);
        return new PollFullDto(pollDto, choicesDto);
    }

    public PollFullDto getPollFullById(UUID pollId) {
        Poll poll = getPollById(pollId);
        List<Choice> choices = getChoicesByPollId(poll);
        List<ChoiceDto> choicesDto = buildChoicesDto(choices);
        PollDto pollDto = pollMapper.to(poll);
        return new PollFullDto(pollDto, choicesDto);
    }

    public Poll save(PollCreateDto pollCreateDto){
        return pollRepository.save(new Poll(
                pollCreateDto.getTitle(),
                pollCreateDto.getCategory()
        ));
    }

    public PollPageDto getAllPollsPage(Pageable pageable) {
        Page<Poll> pollPage = this.pollRepository.findAll(pageable);
        return new PollPageDto(
                pollPage.getTotalPages(),
                pollPage.getTotalElements(),
                pollPage.getSize(),
                this.buildPollsList(pollPage.getContent()
                )
        );
    }

    public List<PollDto> getOthersPolls() {
        List<Poll> polls = this.pollRepository.findOthers();
        polls.remove(0);
        return buildPollsList(polls);
    }

    public PollPageDto getAllPollsByCategory(String category) {
        List<Poll> polls = this.pollRepository.findAllByCategory(category);
        List<PollDto> pollDto = buildPollsList(polls);
        return new PollPageDto(1, Long.parseLong(String.valueOf(pollDto.size())), pollDto.size(), pollDto);
    }

    public List<String> getAllCategories() {
        return pollRepository.findAllCategories();
    }

    public Poll getPollById(UUID pollId) {
        return pollRepository.findById(pollId)
                .orElseThrow(() -> new ResourceNotFoundException(ResourceName.POLL, pollId));
    }

    public Integer getVotes(UUID choiceId){
        return voteService.getNumberOfChoiceVotes(choiceId);
    }

    private List<Choice> getChoicesByPollId(Poll poll){
        return choiceService.findAllByPollId(poll.getId());
    }

    private List<ChoiceDto> buildChoicesDto(List<Choice> choices) {
        ChoiceDto choiceDto1 = choiceMapper.to(choices.get(0), getVotes(choices.get(0).getId()));
        ChoiceDto choiceDto2 = choiceMapper.to(choices.get(1), getVotes(choices.get(1).getId()));
        return List.of(choiceDto1, choiceDto2);
    }

    private List<PollDto> buildPollsList(List<Poll> polls) {
        List<PollDto> pollsDto = pollMapper.to(polls);
        for (PollDto pollDto: pollsDto) {
            List<Choice> choices = choiceService.findAllByPollId(pollDto.getId());
            pollDto.getImages().add(Base64.getEncoder()
                    .withoutPadding()
                    .encodeToString(
                            choices.get(0).getImage()));
            pollDto.getImages().add(Base64.getEncoder()
                    .withoutPadding()
                    .encodeToString(
                            choices.get(1).getImage()));
        }
        return pollsDto;
    }



}
