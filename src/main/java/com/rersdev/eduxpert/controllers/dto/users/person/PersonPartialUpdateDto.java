package com.rersdev.eduxpert.controllers.dto.users.person;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.time.LocalDateTime;

public record PersonPartialUpdateDto(

        String phoneNumber,

        String email,

        String address,

        @JsonIgnore
        LocalDateTime dateUpdated

) implements Serializable {

    public PersonPartialUpdateDto {
        dateUpdated = LocalDateTime.now();
    }
}
