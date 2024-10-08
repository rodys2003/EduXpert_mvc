package com.rersdev.eduxpert.persistences.entities.auth;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "users")
public class User {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private UUID id;

    @Column(unique = true)
    private String documentNumber;

    private String password;

    private Boolean isActive;

    private LocalDateTime dateCreated;

    private  LocalDateTime dateUpdated;
}
