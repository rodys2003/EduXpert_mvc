package com.rersdev.eduxpert.dto.users.person;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rersdev.eduxpert.dto.users.UserPartialInfoDto;

import java.io.Serializable;
import java.time.LocalDate;

public record PersonPartialInfoDto(
        Byte documentType,

        UserPartialInfoDto user,

        String name,

        String lastName,

        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate dateBirth,

        String phoneNumber,

        String gender,

        String email,

        String address
) implements Serializable {
}
