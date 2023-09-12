package com.enqueteque.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "sugestions")
public class Sugestion {

    @Id
    @Column(name = "sugestion_id")
    private UUID id;

    @Column(nullable = false)
    private String sugestion;

    @Column(nullable = false)
    private String contact;

    @Column(nullable = false, name = "contact_type")
    private String contactType;

}
