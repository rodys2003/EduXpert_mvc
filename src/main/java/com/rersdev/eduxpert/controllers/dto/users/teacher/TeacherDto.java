package com.rersdev.eduxpert.controllers.dto.users.teacher;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rersdev.eduxpert.controllers.dto.users.person.PersonDto;

import java.io.Serializable;
import java.time.LocalDate;

public record TeacherDto(

        String specialization,

        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate dateStart,

        @JsonIgnore
        String status,

        PersonDto person

) implements Serializable {

    public TeacherDto {
        if (dateStart == null || status == null) {
            status = "ACTIVO";
            dateStart = LocalDate.now();
        }
    }
}
