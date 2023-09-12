package com.enqueteque.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "polls")
public class Poll {
    @Id
    @Column(name = "poll_id")
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false, name = "create_date")
    private Timestamp createDate;

    public Poll(UUID id, String title, String category, Timestamp createDate){
        this.id = id;
        this.title = title;
        this.category = category;
        this.createDate = createDate;
    };

    public Poll(UUID id, String title, String category){
        this.id = id;
        this.title = title;
        this.category = category;
        this.createDate = Timestamp.from(Instant.from(LocalDate.now()));
    }

}
