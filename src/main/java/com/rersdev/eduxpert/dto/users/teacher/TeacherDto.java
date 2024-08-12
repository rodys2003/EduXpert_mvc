package com.rersdev.eduxpert.dto.users.teacher;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rersdev.eduxpert.dto.users.person.PersonDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDate;

public record TeacherDto(

        @Schema(example = "Matematicas")
        @NotBlank(message = "La especializacion es requerida")
        @Size(max = 50, message = "La espcializacion debe contener menos de 50 caracteres")
        String specialization,

        @Schema(type = "string", example = "25-07-2024", description = "Fecha en formato dd-MM-yyyy")
        @JsonFormat(pattern = "dd-MM-yyyy")
        @PastOrPresent
        LocalDate dateStart,

        @Schema(hidden = true)
        String status,

        @Valid
        PersonDto person

) implements Serializable {

    public TeacherDto {
        if (dateStart == null || status == null) {
            status = "ACTIVO";
            dateStart = LocalDate.now();
        }
    }
}
