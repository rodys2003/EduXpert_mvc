package com.rersdev.eduxpert.controller.dto.get;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetUser implements Serializable {

    private String documentNumber;
}
