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
    private int puntuation;

    @OneToMany(mappedBy = "game")
    private List<Business> developer;

    @ManyToOne
    private Business editor;
    @OneToMany(mappedBy = "game")
    private List<Tag> tags;
    @ElementCollection
    private List<String> languages;

    @OneToMany(mappedBy = "game")
    private List<Review> reviews;
    @OneToMany(mappedBy = "game")
    private List<Achievement> achievements;
    @ElementCollection(fetch = FetchType.EAGER)
    private Map<String,String> images;
    @ManyToOne
    private User user;
    @ManyToMany(mappedBy = "wishGames")
    private List<User> wishGameUsers;

}
