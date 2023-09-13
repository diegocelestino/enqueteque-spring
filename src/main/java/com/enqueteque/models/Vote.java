package com.enqueteque.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "votes")
public class Vote {

    @Id
    @Column(name = "vote_id")
    private UUID id;

    @Column(nullable = false, name = "create_date")
    private Timestamp createDate;

    @Column(nullable = false, name = "choice_id")
    private UUID choiceId;

    public Vote(UUID choiceId){
        this.id = UUID.randomUUID();
        this.createDate = Timestamp.from(Instant.now());
        this.choiceId = choiceId;
    }
}
