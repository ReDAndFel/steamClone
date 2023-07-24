package org.steamclone.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class GameDTO {
    private int id;
    private String name;
    private LocalDate releaseDate;
    private double realPrice;
    private double price;
    private int discount;
    private String description;
    private String requeriments;
    private String clasification;
    private float puntuation;
    private List<BusinessDTO> businesses;
    private List<TagDTO> tags;
    private List<String> languages;
    private List<ImageDTO> images;

}
