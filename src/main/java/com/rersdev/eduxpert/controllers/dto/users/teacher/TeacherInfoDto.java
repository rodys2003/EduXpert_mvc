package com.rersdev.eduxpert.controllers.dto.users.teacher;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rersdev.eduxpert.controllers.dto.users.person.PersonInfoDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class TeacherInfoDto implements Serializable {

        String id;

        String specialization;

        String status;

        @JsonFormat(pattern = "MM-dd-yyyy")
        LocalDate dateStart;

        PersonInfoDto person;
}
