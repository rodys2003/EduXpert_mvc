package com.rersdev.eduxpert.controllers.dto.users;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.time.LocalDateTime;

public record UserDto(

        String documentNumber,

        @JsonIgnore
        String password,

        @JsonIgnore
        Boolean isActive,

        @JsonIgnore
        LocalDateTime dateCreated

) implements Serializable {

    public UserDto {
        isActive = true;
        password = documentNumber;
        dateCreated = LocalDateTime.now();
    }
}