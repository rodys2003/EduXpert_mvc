package com.rersdev.eduxpert.controllers.dto.users.person;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rersdev.eduxpert.controllers.dto.users.UserInfoDto;
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

        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate dateBirth;

        String phoneNumber;

        String gender;

        String email;

        String address;

        @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
        LocalDateTime dateCreated;

        @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
        LocalDateTime dateUpdated;
}
