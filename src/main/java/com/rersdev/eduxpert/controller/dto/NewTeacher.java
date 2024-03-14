package com.rersdev.eduxpert.controller.dto;


import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewTeacher {

    private String specialization;

    private String status;

    private LocalDate dateStart;

    private NewPerson person;
}
