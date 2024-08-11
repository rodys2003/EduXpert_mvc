package com.rersdev.eduxpert.dto.users.teacher;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rersdev.eduxpert.dto.users.person.PersonUpdateDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDate;

public record TeacherUpdateDto(

        @NotBlank(message = "La especializacion es requerida")
        @Size(max = 50, message = "La espcializacion debe contener menos de 50 caracteres")
        String specialization,

        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate dateStart,

        @Valid
        PersonUpdateDto person

) implements Serializable {
}
