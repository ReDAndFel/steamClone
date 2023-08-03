package org.steamclone.services.interfaces;

import org.steamclone.dtos.TransactionDetailDTO;
import org.steamclone.models.entities.TransactionDetail;

import java.util.List;

public interface TransactionDetailInterface {

    public TransactionDetail createTransactionDetail(TransactionDetailDTO transactionDetailDTO) throws Exception;
    List<TransactionDetailDTO> listTransactionDetailByIdTransaction(int idTransaction);

    public TransactionDetailDTO getTransactionDetailDTO(int idTransactionDetail) throws Exception;

}