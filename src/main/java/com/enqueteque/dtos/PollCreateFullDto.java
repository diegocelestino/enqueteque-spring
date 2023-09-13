package com.enqueteque.dtos;

import lombok.Getter;


import java.util.List;

@Getter
public class PollCreateFullDto {
    PollCreateDto pollCreateDto;
    List<ChoiceCreateDto> choices;
}
