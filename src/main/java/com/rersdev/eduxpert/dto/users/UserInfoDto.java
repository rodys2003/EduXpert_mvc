package com.rersdev.eduxpert.dto.users;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class UserInfoDto implements Serializable {

        String documentNumber;

        String password;

        Boolean isActive;

        LocalDateTime dateCreated;

        LocalDateTime dateUpdated;
}
