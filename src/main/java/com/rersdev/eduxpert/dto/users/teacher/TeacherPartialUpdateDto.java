package com.rersdev.eduxpert.dto.users.teacher;

import com.rersdev.eduxpert.dto.users.person.PersonPartialUpdateDto;
import jakarta.validation.Valid;

import java.io.Serializable;

public record TeacherPartialUpdateDto(

        @Valid
        PersonPartialUpdateDto person

) implements Serializable {
}
