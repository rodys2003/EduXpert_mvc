package com.rersdev.eduxpert.controllers.dto.users.teacher;

import com.rersdev.eduxpert.controllers.dto.users.person.PersonPartialUpdateDto;
import jakarta.validation.Valid;

import java.io.Serializable;

public record TeacherPartialUpdateDto(

        @Valid
        PersonPartialUpdateDto person

) implements Serializable {
}
