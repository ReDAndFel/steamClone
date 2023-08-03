package org.steamclone.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TransactionDetailDTO {

    private int id;
    private double price;
    private int transaction;
    private int game;

}
