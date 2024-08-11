package com.rersdev.eduxpert.controllers.dto.users.person;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rersdev.eduxpert.controllers.dto.users.UserDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record PersonDto(

        @NotNull(message = "El numero de documento es requerido ")
        @Max( value = 1, message = "El tipo de documento debe estar entre 1-4")
        Byte documentType,

        @Valid
        UserDto user,

        @NotBlank(message = "Los nombres son requeridos")
        @Size(min = 4, max = 70, message = "Los nombres deben contener de 2 a 70 caracteres")
        String name,

        @NotBlank(message = "Los  apellidos son requeridos")
        @Size(min = 7, max = 80, message = "Los apellidos deben contener de 7 a 80 caracteres")
        String lastName,

        @NotNull(message = "La fecha de nacimiento es requerida")
        @JsonFormat(pattern = "dd-MM-yyyy")
        @Past
        LocalDate dateBirth,

        @NotBlank(message = "El numero telefonico es requerido")
        @Pattern(regexp = "^(\\+)?\\d{10,13}$", message = "El numero telefonico debe tener 10-13 digitos ")
        String phoneNumber,

        @NotBlank(message = "El genero es requerido")
        String gender,

        @NotBlank(message = "El email es  requerido ")
        @Pattern(regexp = "(?i)^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$", message = "El email es invalido")
        String email,

        @Size(min = 8, max = 80, message = "La direccion debe contener de 8 a 80 caracteres")
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
