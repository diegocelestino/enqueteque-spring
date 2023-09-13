package com.enqueteque.dtos;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor(force = true)
@AllArgsConstructor
@Value
public class PollDto {
    UUID id;
    String title;
    String category;
    Timestamp createDate;
    List<String> images;

    public PollDto(UUID id, String title, String category, Timestamp createDate){
        this.id = id;
        this.title = title;
        this.category = category;
        this.createDate = createDate;
        this.images = new ArrayList<String>();
    }

}
