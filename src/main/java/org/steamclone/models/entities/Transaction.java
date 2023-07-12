package org.steamclone.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Transaction implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private float totalPrice;
    @Column(nullable = false)
    private LocalDate date;
    @ManyToOne
    private PaymentMethod paymentMethod;
    @OneToMany(mappedBy = "transaction")
    private List<TransactionDetail> transactionDetails;
    @ManyToOne
    private User user;
}
