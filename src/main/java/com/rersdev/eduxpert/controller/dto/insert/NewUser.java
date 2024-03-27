package com.rersdev.eduxpert.controller.dto.insert;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewUser implements Serializable {

    private String documentNumber;
}
