package com.rersdev.eduxpert.controller.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewPerson {

    private byte documentType;

    private String documentNumber;

    private String name;

    private String lastName;

    private LocalDate dateBirth;

    private String phoneNumber;

    private String gender;

    private  String email;

    private String address;

    private LocalDateTime dateCreated;
}
