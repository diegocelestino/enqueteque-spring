package com.enqueteque.repositories;

import com.enqueteque.models.Choice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ChoiceRepository extends JpaRepository<Choice, UUID> {

    List<Choice> findAllByPollId(UUID pollId);
}
