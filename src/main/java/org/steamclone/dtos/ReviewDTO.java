package org.steamclone.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.steamclone.models.entities.PuntuationReview;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter

public class ReviewDTO {

    private int id;
    private int idUser;
    private int idGame;
    private PuntuationReview puntuation;
    private LocalDate date;
    private String review;

}
