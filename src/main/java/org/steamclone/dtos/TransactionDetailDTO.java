package org.steamclone.dtos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.steamclone.models.entities.Game;
import org.steamclone.models.entities.Transaction;

@AllArgsConstructor
@Getter
@Setter
public class TransactionDetailDTO {

    private int id;
    private float price;
    private int transaction;
    private int game;

}
