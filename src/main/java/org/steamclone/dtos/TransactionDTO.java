package org.steamclone.dtos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.steamclone.models.entities.PaymentMethod;
import org.steamclone.models.entities.TransactionDetail;
import org.steamclone.models.entities.User;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class TransactionDTO {


    private int id;
    private float totalPrice;
    private LocalDate date;
    private List<TransactionDetailDTO> transactionDetails;
    private int user;

}
