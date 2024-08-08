package com.rersdev.eduxpert.controllers.dto.users;

import java.io.Serializable;

public record UserPartialInfoDto(

        String documentNumber

) implements Serializable {
}
