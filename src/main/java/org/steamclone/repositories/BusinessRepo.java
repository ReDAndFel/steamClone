package org.steamclone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.steamclone.dtos.BusinessDTO;
import org.steamclone.models.entities.Business;

import java.util.List;

@Repository
public interface BusinessRepo extends JpaRepository<Business, Integer> {

    @Query("select b from Business b where b.name  like concat('%', :name, '%') and b.state = true")
    List<Business> findByName(String name);

    @Query("select b from Business b where b.name = :name and b.state = true")
    Business getBusinessByName (String name);

    @Query("select b from Business b where b.businessType = :businessType and b.state = true")
    List<Business> findByBusinessType(int businessType);

    @Query("select b from Business b join  b.games g where g.id = :idGame and b.state = true")
    List<Business> listBusinessByIdGame(int idGame);

}
