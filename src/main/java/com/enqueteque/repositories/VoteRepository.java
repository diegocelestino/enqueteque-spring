package com.enqueteque.repositories;

import com.enqueteque.models.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface VoteRepository extends JpaRepository<Vote, UUID> {

    @Query(value = "SELECT COUNT(*) FROM votes WHERE votes.choice_id = ?1",
            nativeQuery = true)
    Integer countVotesByChoiceId(UUID choiceId);
}
