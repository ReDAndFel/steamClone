package org.steamclone.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.steamclone.models.entities.Game;
import org.steamclone.models.entities.User;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class AchievementDTO {

    private int id;
    private String name;
    private String description;
    private int idGame;

}
