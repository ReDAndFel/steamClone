package org.steamclone.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.steamclone.models.entities.BusinessType;
@AllArgsConstructor
@Getter
@Setter
public class BusinessDTO {

    private int id;
    private String name;
    private BusinessType businessType;

    private boolean state;

}
