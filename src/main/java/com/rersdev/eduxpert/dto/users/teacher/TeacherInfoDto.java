package com.rersdev.eduxpert.dto.users.teacher;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.rersdev.eduxpert.dto.users.person.PersonInfoDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class TeacherInfoDto implements Serializable {

    String id;

    String specialization;

    String status;

    @Schema(type = "string", example = "20-05-1998")
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate dateStart;

    PersonInfoDto person;
}
