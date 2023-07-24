package org.steamclone.services.implementations;

import org.springframework.stereotype.Service;
import org.steamclone.dtos.TransactionDTO;
import org.steamclone.services.interfaces.TransactionInterface;

import java.util.List;
@Service
public class TransactionInterfaceImpl implements TransactionInterface {
    @Override
    public int createTransaction(TransactionDTO transactionDTO) {
        return 0;
    }

    @Override
    public List<TransactionDTO> listTransactionByIdUser(int idUser) {
        return null;
    }

    @Override
    public TransactionDTO getTransactionDTO(int idTransactionDTO) {
        return null;
    }
}
