package org.steamclone.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.steamclone.models.entities.Transaction;
import org.steamclone.models.entities.User;

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
