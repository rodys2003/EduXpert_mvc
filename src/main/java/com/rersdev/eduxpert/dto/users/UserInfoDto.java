package com.rersdev.eduxpert.dto.users;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
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

        @Schema(type = "string", example = "20-05-1998 11:10")
        @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
        LocalDateTime dateCreated;

        @Schema(type = "string", example = "20-05-1998 11:10")
        @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
        LocalDateTime dateUpdated;
}
