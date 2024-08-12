package com.rersdev.eduxpert.dto.users.person;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rersdev.eduxpert.dto.users.UserInfoDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class PersonInfoDto implements Serializable {

    Byte documentType;

    UserInfoDto user;

    String name;

    String lastName;

    @Schema(type = "string", example = "20-05-1998")
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate dateBirth;

    String phoneNumber;

    String gender;

    String email;

    String address;

    @Schema(type = "string", example = "20-05-1998 11:10")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    LocalDateTime dateCreated;

    @Schema(type = "string", example = "20-05-1998 11:10")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    LocalDateTime dateUpdated;
}
