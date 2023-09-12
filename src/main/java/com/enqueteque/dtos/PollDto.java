package com.enqueteque.dtos;

import lombok.Value;
import java.sql.Timestamp;
import java.util.UUID;

@Value
public class PollDto {

    UUID id;
    String title;
    String category;
    Timestamp createDate;

}
