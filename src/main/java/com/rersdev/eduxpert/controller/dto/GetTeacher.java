package com.rersdev.eduxpert.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetTeacher {

    private String specialization;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateStart;

    GetPerson person;
}
