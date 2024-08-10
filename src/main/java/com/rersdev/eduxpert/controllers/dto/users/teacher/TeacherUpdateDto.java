package com.rersdev.eduxpert.controllers.dto.users.teacher;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rersdev.eduxpert.controllers.dto.users.person.PersonUpdateDto;

import java.io.Serializable;
import java.time.LocalDate;

public record TeacherUpdateDto(

        String specialization,

        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate dateStart,

        PersonUpdateDto person

) implements Serializable {
}
