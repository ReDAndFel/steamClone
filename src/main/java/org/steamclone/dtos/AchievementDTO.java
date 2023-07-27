package org.steamclone.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class AchievementDTO {

    private int id;
    private String name;
    private String description;
    private int idGame;
    private boolean state;

}
