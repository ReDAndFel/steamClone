package org.steamclone.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class SesionDTO {

    @NotNull
    @Email
    private String email;
    @NotNull
    private String password;

}
