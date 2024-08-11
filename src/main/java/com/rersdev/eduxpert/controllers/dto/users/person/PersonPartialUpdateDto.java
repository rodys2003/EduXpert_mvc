package com.rersdev.eduxpert.controllers.dto.users.person;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDateTime;

public record PersonPartialUpdateDto(

        @NotBlank(message = "El numero telefonico es requerido")
        @Pattern(regexp = "^(\\+)?\\d{10,13}$", message = "El numero telefonico debe tener 10-13 digitos ")
        String phoneNumber,

        @NotBlank(message = "El email es  requerido ")
        @Pattern(regexp = "(?i)^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$", message = "El email es invalido")
        String email,

        @Size(min = 8, max = 80, message = "La direccion debe contener de 8 a 80 caracteres")
        String address,

        @JsonIgnore
        LocalDateTime dateUpdated

) implements Serializable {

    public PersonPartialUpdateDto {
        dateUpdated = LocalDateTime.now();
    }
}
