package org.steamclone.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Game implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private LocalDate releaseDate;
    @Column(nullable = false)
    private double realPrice;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false, length = 3)
    private int discount;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String requeriments;
    @Column(nullable = false)
    private String clasification;
    @Column(nullable = false)
    private float puntuation;
    @Column(nullable = false)
    private boolean state;
    @ManyToMany
    private List<Business> businesses;
    @ManyToMany
    private List<Tag> tags;
    @ElementCollection
    private List<String> languages;
    @OneToMany(mappedBy = "game")
    private List<Review> reviews;
    @OneToMany(mappedBy = "game")
    private List<Achievement> achievements;
    @ElementCollection
    private Map<String,String> images;
    @ManyToMany
    private List<User> users;
    @ManyToMany(mappedBy = "wishGames")
    private List<User> wishGameUsers;

    @OneToMany(mappedBy = "game")
    private List<TransactionDetail> transactionDetail;
}
