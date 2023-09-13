package com.enqueteque.dtos;

import lombok.Value;

import java.util.UUID;

@Value
public class VoteCreateDto {
    UUID choiceId;
}
