package org.steamclone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.steamclone.models.entities.PaymentMethod;

import java.util.List;

@Repository
public interface PaymentMethodRepo extends JpaRepository<PaymentMethod, Integer> {

    @Query("select p from PaymentMethod p where p.user = :idUser")
    List<PaymentMethod> listPaymentMethodByIdUser(int idUser);

}
