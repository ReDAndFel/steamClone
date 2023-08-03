package org.steamclone.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProfileComment implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private User user;
    @Column(nullable = false)
    private String comment;
    @Column(nullable = false)
    private LocalDate date;
    @ManyToOne
    private User profileUser;

    @Column(nullable = false)
    private boolean state;

}
