package com.rersdev.eduxpert.persistence.entity;

import com.rersdev.eduxpert.persistence.entity.auth.User;
import com.rersdev.eduxpert.persistence.entity.enums.Gender;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "people")
public class Person {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private UUID id;

    private Byte documentType;

    private String name;

    private String lastName;

    private LocalDate dateBirth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String phoneNumber;

    private String email;

    private String address;

    private LocalDateTime dateCreated;

    private LocalDateTime dateUpdated;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private User user;
}
