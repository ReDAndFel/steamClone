package org.steamclone.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.steamclone.dtos.TransactionDetailDTO;
import org.steamclone.models.entities.Game;
import org.steamclone.models.entities.TransactionDetail;
import org.steamclone.repositories.TransactionDetailRepo;
import org.steamclone.repositories.TransactionRepo;
import org.steamclone.services.interfaces.GameInterface;
import org.steamclone.services.interfaces.TransactionDetailInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class TransactionDetailInterfaceImpl implements TransactionDetailInterface {

    @Autowired
    private GameInterface gameInterface;
    @Autowired
    TransactionRepo transactionRepo;
    @Autowired
    private TransactionDetailRepo transactionDetailRepo;

    @Override
    public TransactionDetail createTransactionDetail(TransactionDetailDTO transactionDetailDTO) throws Exception {
        TransactionDetail transactionDetail = new TransactionDetail();

        System.out.println("Id del producto en detail transaccion es " + transactionDetailDTO.getGame());

        Game game = gameInterface.getGame(transactionDetailDTO.getGame());

        transactionDetail.setTransaction(transactionDetail.getTransaction());
        transactionDetail.setGame(game);
        transactionDetail.setPrice(game.getPrice());

        transactionDetailRepo.save(transactionDetail);

        return transactionDetail;
    }

    @Override
    public List<TransactionDetailDTO> listTransactionDetailByIdTransaction(int idTransaction) {
        List<TransactionDetail> listTransactionDetailByTransaction = transactionDetailRepo.listTransactionDetailByIdTransaction(idTransaction);
        List<TransactionDetailDTO> listTransactionDetailDTOByTransaction = new ArrayList<>();

        for (TransactionDetail transactionDetail: listTransactionDetailByTransaction) {
            listTransactionDetailDTOByTransaction.add(convertToGetDTO(transactionDetail));        }

        return listTransactionDetailDTOByTransaction;
    }

    private TransactionDetailDTO convertToGetDTO(TransactionDetail transactionDetail) {
        TransactionDetailDTO transactionDetailDTO = new TransactionDetailDTO(
                transactionDetail.getId(),
                transactionDetail.getPrice(),
                transactionDetail.getTransaction().getId(),
                transactionDetail.getGame().getId()
        );

        return transactionDetailDTO;
    }

    @Override
    public TransactionDetailDTO getTransactionDetailDTO(int idTransactionDetail) throws Exception {

        Optional<TransactionDetail> foundTransactionDetail = transactionDetailRepo.findById(idTransactionDetail);

        if (foundTransactionDetail.isEmpty()) {
            throw new Exception("No existe un detalle transacción con el id " + idTransactionDetail);
        }

        TransactionDetail transactionDetail = foundTransactionDetail.get();
        return convertToGetDTO(transactionDetail);
    }
}
