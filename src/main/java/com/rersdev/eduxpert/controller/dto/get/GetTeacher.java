package com.rersdev.eduxpert.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetTeacher implements Serializable {

    private String specialization;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateStart;

    GetPerson person;
}
