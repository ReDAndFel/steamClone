package org.steamclone.services.interfaces;


import org.steamclone.dtos.TransactionDTO;

import java.util.List;

public interface TransactionInterface {

    public int createTransaction(TransactionDTO transactionDTO) throws Exception;
    List<TransactionDTO> listTransactionByIdUser(int idUser);

    public TransactionDTO getTransactionDTO(int idTransactionDTO) throws Exception;
}
