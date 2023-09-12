package com.enqueteque.mappers;

import com.enqueteque.dtos.PollDto;
import com.enqueteque.models.Poll;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PollMapper {
    PollDto to(Poll poll);
}
