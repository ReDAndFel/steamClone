package org.steamclone.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class PaymentMethodDTO {

    private int id;
    private String bankingEntity;
    private String cardNumber;
    private String titularName;
    private LocalDate expirationDate;
    private int cvv;
    private  boolean state;
    private int idUser;
    private List<TransactionDTO> transactions;

}
