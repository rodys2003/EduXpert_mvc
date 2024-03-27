package com.rersdev.eduxpert.controller.dto.insert;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewTeacher implements Serializable {

    private String specialization;

    private LocalDate dateStart;

    private NewPerson person;
}
