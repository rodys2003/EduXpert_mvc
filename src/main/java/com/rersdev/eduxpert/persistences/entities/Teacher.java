package com.rersdev.eduxpert.persistences.entities;

import com.rersdev.eduxpert.persistences.entities.enums.TeacherStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private UUID id;

    private String specialization;

    @Enumerated(EnumType.STRING)
    private TeacherStatus status;

    private LocalDate dateStart;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER,orphanRemoval = true)
    private Person person;
}
