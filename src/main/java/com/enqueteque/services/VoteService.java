package com.enqueteque.services;

import com.enqueteque.models.Vote;
import com.enqueteque.repositories.VoteRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
@Log4j2
public class VoteService {
    private final VoteRepository voteRepository;

    public void save(UUID choiceId) {
        voteRepository.save(new Vote(choiceId));
    }

    public Integer getNumberOfChoiceVotes(UUID choiceId) {
        return voteRepository.countVotesByChoiceId(choiceId);
    }
}
