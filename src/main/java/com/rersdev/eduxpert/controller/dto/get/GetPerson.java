package com.rersdev.eduxpert.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetPerson implements Serializable {

    private GetUser user;

    private Byte documentType;

    private String name;

    private String lastName;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateBirth;

    private String phoneNumber;

    private String gender;

    private  String email;

    private String address;
}
