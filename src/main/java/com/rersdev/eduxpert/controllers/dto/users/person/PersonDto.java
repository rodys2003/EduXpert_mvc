package com.rersdev.eduxpert.controllers.dto.users.person;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rersdev.eduxpert.controllers.dto.users.UserDto;
import jakarta.validation.constraints.Past;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record PersonDto(

        Byte documentType,

        UserDto user,

        String name,

        String lastName,

        @JsonFormat(pattern = "dd-MM-yyyy")
        @Past
        LocalDate dateBirth,

        String phoneNumber,

        String gender,

        String email,

        String address,

        @JsonIgnore
        LocalDateTime dateCreated,

        @JsonIgnore
        LocalDateTime dateUpdated

) implements Serializable {

    public PersonDto {
        dateUpdated = LocalDateTime.now();

        if (dateCreated == null) {
            dateCreated = LocalDateTime.now();
        }
    }
}
