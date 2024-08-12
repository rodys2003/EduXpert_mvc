package com.rersdev.eduxpert.dto.users.teacher;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rersdev.eduxpert.dto.users.person.PersonPartialInfoDto;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.time.LocalDate;

public record TeacherPartialInfoDto(

        String id,

        String specialization,

        @Schema(type = "string", example = "20-05-1998")
        @JsonFormat(pattern = "MM-dd-yyyy")
        LocalDate dateStart,

        PersonPartialInfoDto person

) implements Serializable {
}
