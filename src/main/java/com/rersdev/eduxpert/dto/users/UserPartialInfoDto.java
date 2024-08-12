package com.rersdev.eduxpert.dto.users;

import java.io.Serializable;

public record UserPartialInfoDto(

        String documentNumber

) implements Serializable {
}
