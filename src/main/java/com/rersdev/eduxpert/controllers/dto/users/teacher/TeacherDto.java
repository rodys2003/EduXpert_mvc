package com.rersdev.eduxpert.controllers.dto.users.teacher;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rersdev.eduxpert.controllers.dto.users.person.PersonDto;

import java.io.Serializable;
import java.time.LocalDate;

public record TeacherDto(

        String specialization,

        LocalDate dateStart,

        @JsonIgnore
        String status,

        PersonDto person

) implements Serializable {

    public TeacherDto {
        status = "ACTIVO";

        if (dateStart == null) {
            dateStart = LocalDate.now();
        }
    }
}
