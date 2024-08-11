package com.rersdev.eduxpert.dto.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.time.LocalDateTime;

public record UserDto(

        @NotBlank(message = "El numero de documento es requerido")
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