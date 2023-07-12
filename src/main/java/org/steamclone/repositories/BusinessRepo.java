package org.steamclone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.steamclone.models.entities.Business;

@Repository
public interface BusinessRepo extends JpaRepository<Business, Integer> {

    @Query("select b from Business b where b.name  like concat('%', :name, '%')")
    Business findByName(String name);

    @Query("select b from Business b where b.businessType = :businessType")
    Business findByBusinessType(int businessType);

}
