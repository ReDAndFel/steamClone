package org.steamclone.services.interfaces;

import org.springframework.stereotype.Repository;
import org.steamclone.dtos.ReviewDTO;
import org.steamclone.dtos.TransactionDTO;
import org.steamclone.dtos.TransactionDetailDTO;
import org.steamclone.models.entities.TransactionDetail;


import java.util.List;

public interface TransactionDetailInterface {

    public int createTransactionDetail(TransactionDetailDTO transactionDetailDTO);
    List<TransactionDetailDTO> listTransactionDetailByIdTransaction(int idTransaction);

    public TransactionDetailDTO getTransactionDetailDTO(int idTransactionDetail);

}