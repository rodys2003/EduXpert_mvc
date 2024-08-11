package com.rersdev.eduxpert.dto.users.teacher;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rersdev.eduxpert.dto.users.person.PersonDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDate;

public record TeacherDto(

        @NotBlank(message = "La especializacion es requerida")
        @Size(max = 50, message = "La espcializacion debe contener menos de 50 caracteres")
        String specialization,

        @JsonFormat(pattern = "dd-MM-yyyy")
        @PastOrPresent
        LocalDate dateStart,

        @JsonIgnore
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
