package com.rersdev.eduxpert.dto.users.person;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rersdev.eduxpert.dto.users.UserDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record PersonDto(

        @Schema(type = "integer", example = "1")
        @NotNull(message = "El numero de documento es requerido ")
        @Max(value = 1, message = "El tipo de documento debe estar entre 1-4")
        Byte documentType,

        @Valid
        UserDto user,

        @Schema(example = "Luis Alberto")
        @NotBlank(message = "Los nombres son requeridos")
        @Size(min = 4, max = 70, message = "Los nombres deben contener de 2 a 70 caracteres")
        String name,

        @Schema(example = "Suarez Lopez")
        @NotBlank(message = "Los  apellidos son requeridos")
        @Size(min = 7, max = 80, message = "Los apellidos deben contener de 7 a 80 caracteres")
        String lastName,

        @Schema(type = "string", example = "20-05-1998", description = "Fecha en formato dd-MM-yyyy")
        @NotNull(message = "La fecha de nacimiento es requerida")
        @JsonFormat(pattern = "dd-MM-yyyy")
        @Past
        LocalDate dateBirth,

        @Schema(example = "3152467895")
        @NotBlank(message = "El numero telefonico es requerido")
        @Pattern(regexp = "^(\\+)?\\d{10,13}$", message = "El numero telefonico debe tener 10-13 digitos ")
        String phoneNumber,

        @Schema(example = "HOMBRE", description = "EL genero debe estar en Mayuscula")
        @NotBlank(message = "El genero es requerido")
        String gender,

        @Schema(example = "luis01@gmail.com")
        @NotBlank(message = "El email es  requerido ")
        @Pattern(regexp = "(?i)^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$", message = "El email es invalido")
        String email,

        @Schema(example = "Cra.7 # 11-10, la candelaria, bogota")
        @Size(min = 8, max = 80, message = "La direccion debe contener de 8 a 80 caracteres")
        String address,

        @Schema(hidden = true)
        LocalDateTime dateCreated,

        @Schema(hidden = true)
        LocalDateTime dateUpdated

) implements Serializable {

    public PersonDto {
        dateUpdated = LocalDateTime.now();

        if (dateCreated == null) {
            dateCreated = LocalDateTime.now();
        }
    }
}
