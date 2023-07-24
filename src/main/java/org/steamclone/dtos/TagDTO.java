package org.steamclone.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.steamclone.models.entities.Game;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class TagDTO {

    private int id;
    private String name;
    private List<GameDTO> games;

}
