package org.steamclone.services.implementations;

import org.springframework.stereotype.Service;
import org.steamclone.dtos.TransactionDetailDTO;
import org.steamclone.services.interfaces.TransactionDetailInterface;

import java.util.List;
@Service
public class TransactionDetailInterfaceImpl implements TransactionDetailInterface {
    @Override
    public int createTransactionDetail(TransactionDetailDTO transactionDetailDTO) {
        return 0;
    }

    @Override
    public List<TransactionDetailDTO> listTransactionDetailByIdTransaction(int idTransaction) {
        return null;
    }

    @Override
    public TransactionDetailDTO getTransactionDetailDTO(int idTransactionDetail) {
        return null;
    }
}
