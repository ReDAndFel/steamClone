package org.steamclone.services.interfaces;


import org.springframework.stereotype.Repository;
import org.steamclone.dtos.ReviewDTO;
import org.steamclone.dtos.TransactionDTO;


import java.util.List;

public interface TransactionInterface {

    public int createTransaction(TransactionDTO transactionDTO);
    List<TransactionDTO> listTransactionByIdUser(int idUser);

    public TransactionDTO getTransactionDTO(int idTransactionDTO);
}
