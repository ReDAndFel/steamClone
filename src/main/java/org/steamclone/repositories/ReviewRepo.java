package org.steamclone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.steamclone.models.entities.Review;

import java.util.List;

@Repository
public interface ReviewRepo extends JpaRepository<ReviewRepo, Integer> {

    @Query("select r from Review r where r.puntuation = :puntuation")
    List<Review> findByPuntuation(int puntuation);

    @Query("select r from Review r where r.game.id = :idGame")
    List<Review> findByGame(int idGame);

}
