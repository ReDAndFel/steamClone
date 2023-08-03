package org.steamclone.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.steamclone.dtos.TransactionDTO;
import org.steamclone.dtos.TransactionDetailDTO;
import org.steamclone.models.entities.Transaction;
import org.steamclone.models.entities.TransactionDetail;
import org.steamclone.models.entities.User;
import org.steamclone.repositories.GameRepo;
import org.steamclone.repositories.TransactionRepo;
import org.steamclone.services.interfaces.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionInterfaceImpl implements TransactionInterface {

    @Autowired
    private PaymentMethodInterface paymentMethodInterface;
    @Autowired
    private UserInterface userInterface;
    @Autowired
    private GameInterface gameInterface;
    @Autowired
    private GameRepo gameRepo;
    @Autowired
    private TransactionRepo transactionRepo;
    @Autowired
    private TransactionDetailInterface transactionDetailInterface;
    @Override
    public int createTransaction(TransactionDTO transactionDTO) throws Exception {
        Transaction transaction = new Transaction();

        System.out.println("id metodo de pago = " + transactionDTO.getIdPaymentMethodDTO());
        System.out.println("id persona que comproa = " + transactionDTO.getIdUser());

        transaction.setPaymentMethod(paymentMethodInterface.getPayment(transactionDTO.getIdPaymentMethodDTO()));
        User user = userInterface.getUser(transactionDTO.getIdUser());
        transaction.setUser(user);
        transaction.setDate(LocalDate.now());

        List<TransactionDetail> transactionDetails = new ArrayList<>();

        float priceTotal=0;

        for (TransactionDetailDTO transactionDetailDTO:transactionDTO.getTransactionDetails()) {
            System.out.println("el id del producto del detalle transaccion antes de crearse (DTO) es " + transactionDetailDTO.getGame());
            TransactionDetail transactionDetail = transactionDetailInterface.createTransactionDetail(transactionDetailDTO);
            transactionDetails.add(transactionDetail);
            priceTotal+=transactionDetail.getPrice();
        }

        transaction.setTransactionDetails(transactionDetails);
        transaction.setTotalPrice(priceTotal);
        transactionRepo.save(transaction);

        String infoDetails= "<p>" + user.getName() + " ha realizado su transaccion con un valor de $" + priceTotal + " con exito.</p>";
        infoDetails+="<h3>Detalles de la transacción:</h3>";

        for (TransactionDetail transactionDetail :transactionDetails) {
            infoDetails+="<p><b>Producto:</b> " + transactionDetail.getGame().getName() + "  <b>precio:</b> $" + transactionDetail.getPrice() + "</p>";
        }
        System.out.println(infoDetails);

        //emailInterface.sendEmail(new EmailDTO("Transaccion realizada",infoDetails, person.getEmail()));

        return transaction.getId();
    }

    @Override
    public List<TransactionDTO> listTransactionByIdUser(int idUser) {
        List<Transaction> transactionsByPerson = transactionRepo.listTransactionByIdUser(idUser);
        List<TransactionDTO> listTransactionsDTOByPerson = new ArrayList<>();

        for (Transaction transaction: transactionsByPerson) {
            listTransactionsDTOByPerson.add(convertToGetDTO(transaction));
        }

        return listTransactionsDTOByPerson;
    }

    private TransactionDTO convertToGetDTO(Transaction transaction) {
        TransactionDTO transactionGetDTO = new TransactionDTO(
                transaction.getId(),
                transaction.getTotalPrice(),
                transaction.getDate(),
                transactionDetailInterface.listTransactionDetailByIdTransaction(transaction.getId()),
                transaction.getUser().getId(),
                transaction.getPaymentMethod().getId()

        );

        return transactionGetDTO;
    }

    @Override
    public TransactionDTO getTransactionDTO(int idTransactionDTO) throws Exception {
        Optional<Transaction> foundTransaction = transactionRepo.findById(idTransactionDTO);

        if (foundTransaction.isEmpty()) {
            throw new Exception("No existe una transaccion con el id " + idTransactionDTO);
        }

        Transaction transaction = foundTransaction.get();
        return convertToGetDTO(transaction);
    }
}
