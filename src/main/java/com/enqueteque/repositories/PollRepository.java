package com.enqueteque.repositories;

import com.enqueteque.models.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PollRepository extends JpaRepository<Poll, UUID> {
    List<Poll> findAllByCategory(String category);

    @Query(value = "SELECT DISTINCT category FROM polls",
            nativeQuery = true)
    List<String> findAllCategories();
}
