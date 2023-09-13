package com.enqueteque.dtos;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.List;

@NoArgsConstructor(force = true)
@AllArgsConstructor
@Value
public class PollFullDto {
    PollDto pollDto;
    List<ChoiceDto> choices;
}
