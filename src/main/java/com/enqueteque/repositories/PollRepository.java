package com.enqueteque.repositories;

import com.enqueteque.dtos.PollDto;
import com.enqueteque.dtos.PollFullDto;
import com.enqueteque.models.Poll;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PollRepository extends JpaRepository<Poll, UUID> {
    List<Poll> findAllByCategory(String category);

    @Query(value = "SELECT DISTINCT category FROM polls",
            nativeQuery = true)
    List<String> findAllCategories();


    @Query(value = "SELECT *FROM polls ORDER BY create_date DESC LIMIT 1",
            nativeQuery = true)
    Poll findLatest();


    @Query(value = "SELECT *FROM polls ORDER BY create_date DESC LIMIT 6",
            nativeQuery = true)
    List<Poll> findOthers();

}
