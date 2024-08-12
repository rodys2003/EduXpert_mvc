package com.rersdev.eduxpert.dto.users;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.io.Serializable;
import java.time.LocalDateTime;

public record UserDto(

        @Schema(example = "100002458")
        @NotBlank(message = "El numero de documento es requerido")
        @Pattern(regexp = "^\\d{6,15}$\n", message = "El numero de documento debe contener solo numeros y" +
                " una longitud de 6-15 digitos")
        String documentNumber,

        @Schema(hidden = true)
        String password,

        @Schema(hidden = true)
        Boolean isActive,

        @Schema(hidden = true)
        LocalDateTime dateCreated

) implements Serializable {

    public UserDto {
        isActive = true;
        password = documentNumber;
        dateCreated = LocalDateTime.now();
    }
}