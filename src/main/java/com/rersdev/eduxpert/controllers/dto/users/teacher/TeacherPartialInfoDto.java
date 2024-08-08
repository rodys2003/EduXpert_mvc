package com.rersdev.eduxpert.controllers.dto.users.teacher;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rersdev.eduxpert.controllers.dto.users.person.PersonPartialInfoDto;

import java.io.Serializable;
import java.time.LocalDate;

public record TeacherPartialInfoDto(

        String id,

        String specialization,

        @JsonFormat(pattern = "MM-dd-yyyy")
        LocalDate dateStart,

        PersonPartialInfoDto person

) implements Serializable {
}
