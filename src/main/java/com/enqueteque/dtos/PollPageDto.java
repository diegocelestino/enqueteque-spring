package com.enqueteque.dtos;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.List;

@NoArgsConstructor(force = true)
@AllArgsConstructor
@Value
public class PollPageDto {
    Integer totalPages;
    Long totalElements;
    Integer size;
    List<PollDto> pollDtoList;

}
