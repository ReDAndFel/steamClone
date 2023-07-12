package org.steamclone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.steamclone.models.entities.TransactionDetail;

import java.util.List;

@Repository
public interface TransactionDetailRepo extends JpaRepository<TransactionDetail, Integer> {

    @Query("select td from TransactionDetail td where td.transaction = :idTransaction")
    List<TransactionDetail> listTransactionDetailByIdTransaction(int idTransaction);

}
