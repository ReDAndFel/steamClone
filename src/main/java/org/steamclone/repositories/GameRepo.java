package org.steamclone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.steamclone.models.entities.Game;

import java.util.List;

@Repository
public interface GameRepo extends JpaRepository<Game, Integer> {
    @Query("select g from Game g join g.tags t where t.name = :tag ")
    List<Game> listGameByTag(String tag);
    @Query("select g from Game g where g.name like concat('%', :name, '%')")
    List<Game> listGameByName(String name);

    @Query("select g from Game g where g.price between :minPrice and :maxPrice")
    List<Game> listGameByPrice(float minPrice, float maxPrice);

    @Query("select g from Game g join g.businesses b where  b.name= :nameBusiness")
    List<Game> listGameByBusiness(String nameBusiness);


    @Query("select g from Game g join g.wishGameUsers w where w.id = :idUser")
    List<Game> listFavoriteProduct(String idUser);

    @Query("select g from Game g where g.puntuation between :minPuntuation and :maxPuntuation")
    List<Game> findByPuntuation(float puntuation);
}
