package com.enqueteque.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "choices")
public class Choice {

    @Id
    @Column(name = "choice_id")
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private byte[] image;

    @Column(nullable = false, name = "poll_id")
    private UUID pollId;

    public Choice(String title, byte[] image, UUID pollId){
        this.id = UUID.randomUUID();
        this.title = title;
        this.image = image;
        this.pollId = pollId;
    }


}
