package com.rersdev.eduxpert.controller.dto.insert;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewUser implements Serializable {

    private String documentNumber;

    private String password;

    private LocalDateTime dateCreated;
}
