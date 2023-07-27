package org.steamclone.services.implementations;

import org.springframework.stereotype.Service;
import org.steamclone.dtos.PaymentMethodDTO;
import org.steamclone.models.entities.PaymentMethod;
import org.steamclone.repositories.PaymentMethodRepo;
import org.steamclone.repositories.UserRepo;
import org.steamclone.services.interfaces.PaymentMethodInterface;
import org.steamclone.services.interfaces.TransactionInterface;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentMethodInterfaceImpl implements PaymentMethodInterface {

    TransactionInterface transactionInterface;
    PaymentMethodRepo paymentMethodRepo;

    UserRepo userRepo;

    @Override
    public int createPaymentMethod(PaymentMethodDTO paymentMethodDTO) throws Exception {

        PaymentMethod foundPaymentMethod = paymentMethodRepo.findByCardNumber(paymentMethodDTO.getCardNumber());

        if(foundPaymentMethod != null){
            throw new Exception("Ya existe un metodo de pago con el numero " + paymentMethodDTO.getCardNumber());
        }

        PaymentMethod paymentMethod = new PaymentMethod();

        paymentMethod.setBankingEntity(paymentMethodDTO.getBankingEntity());
        paymentMethod.setCvv(paymentMethodDTO.getCvv());
        paymentMethod.setCardNumber(paymentMethodDTO .getCardNumber());
        paymentMethod.setExpirationDate(paymentMethodDTO.getExpirationDate());
        paymentMethod.setTitularName(paymentMethodDTO.getTitularName());
        paymentMethod.setUser(userRepo.findById(paymentMethodDTO.getIdUser()).get());
        paymentMethod.setState(true);

        paymentMethodRepo.save(paymentMethod);

        return paymentMethod.getId();

    }

    @Override
    public int updatePaymentMethod(int idPaymentMethod, PaymentMethodDTO paymentMethodDTO) {
        return 0;
    }

    @Override
    public int deletePaymentMethod(int idPaymentMethod) {
        return 0;
    }

    @Override
    public List<PaymentMethodDTO> listPaymentMethodUser(int idUser) {
        return null;
    }

    @Override
    public PaymentMethod getPaymentDTO(int idPaymentMethod) {
        return null;
    }

    public  PaymentMethodDTO converToDTO(PaymentMethod paymentMethod){
        PaymentMethodDTO paymentMethodDTO = new PaymentMethodDTO(
                paymentMethod.getId(),
                paymentMethod.getBankingEntity(),
                paymentMethod.getCardNumber(),
                paymentMethod.getTitularName(),
                paymentMethod.getExpirationDate(),
                paymentMethod.getCvv(),
                paymentMethod.isState(),
                paymentMethod.getUser().getId(),
                transactionInterface.listTransactionByIdUser(paymentMethod.getUser().getId())

        );

        return paymentMethodDTO;
    }
}
