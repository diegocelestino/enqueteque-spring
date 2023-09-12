package com.enqueteque.dtos;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.sql.Timestamp;
import java.util.UUID;

@NoArgsConstructor(force = true)
@AllArgsConstructor
@Value
public class PollDto {
    UUID id;
    String title;
    String category;
    Timestamp createDate;
}
