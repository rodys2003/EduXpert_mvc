package com.rersdev.eduxpert.controller.dto.insert;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewPerson implements Serializable {

    private Byte documentType;

    NewUser user;

    private String name;

    private String lastName;

    private LocalDate dateBirth;

    private String phoneNumber;

    private String gender;

    private  String email;

    private String address;

    private LocalDateTime dateCreated;
}
