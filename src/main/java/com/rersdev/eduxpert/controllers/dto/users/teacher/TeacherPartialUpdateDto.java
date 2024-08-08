package com.rersdev.eduxpert.controllers.dto.users.teacher;

import com.rersdev.eduxpert.controllers.dto.users.person.PersonPartialUpdateDto;

import java.io.Serializable;

public record TeacherPartialUpdateDto(

        PersonPartialUpdateDto person

) implements Serializable {
}
