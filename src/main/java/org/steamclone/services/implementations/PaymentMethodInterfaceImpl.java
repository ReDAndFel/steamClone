package org.steamclone.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.steamclone.dtos.PaymentMethodDTO;
import org.steamclone.models.entities.PaymentMethod;
import org.steamclone.repositories.PaymentMethodRepo;
import org.steamclone.repositories.UserRepo;
import org.steamclone.services.interfaces.PaymentMethodInterface;
import org.steamclone.services.interfaces.TransactionInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentMethodInterfaceImpl implements PaymentMethodInterface {

    @Autowired
    TransactionInterface transactionInterface;
    @Autowired
    PaymentMethodRepo paymentMethodRepo;
    @Autowired
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
    public int updatePaymentMethod(int idPaymentMethod, PaymentMethodDTO paymentMethodDTO) throws Exception {

        Optional<PaymentMethod> foundPaymentMethod = paymentMethodRepo.findById(idPaymentMethod);

        if(foundPaymentMethod.isEmpty()){
            throw new Exception("No existe un metodo de pago con el id " + idPaymentMethod);
        }

        PaymentMethod updatePaymentMethod = foundPaymentMethod.get();

        PaymentMethod validCardNumber = paymentMethodRepo.findByCardNumber(paymentMethodDTO.getCardNumber());

        if(foundPaymentMethod == null){
            throw new Exception("Ya existe un metodo de pago con el numero " + paymentMethodDTO.getCardNumber());
        }

        updatePaymentMethod.setBankingEntity(paymentMethodDTO.getBankingEntity());
        updatePaymentMethod.setCvv(paymentMethodDTO.getCvv());
        updatePaymentMethod.setCardNumber(paymentMethodDTO .getCardNumber());
        updatePaymentMethod.setExpirationDate(paymentMethodDTO.getExpirationDate());
        updatePaymentMethod.setTitularName(paymentMethodDTO.getTitularName());

        paymentMethodRepo.save(updatePaymentMethod);

        return updatePaymentMethod.getId();

    }

    @Override
    public boolean deletePaymentMethod(int idPaymentMethod) throws Exception {

        Optional<PaymentMethod> foundPaymentMethod = paymentMethodRepo.findById(idPaymentMethod);

        if(foundPaymentMethod.isEmpty()){
            throw new Exception("No existe un metodo de pago con el id " + idPaymentMethod);
        }

        PaymentMethod deletePaymentMethod = foundPaymentMethod.get();

        deletePaymentMethod.setState(false);

        paymentMethodRepo.save(deletePaymentMethod);

        return deletePaymentMethod.isState();
    }

    @Override
    public List<PaymentMethodDTO> listPaymentMethodUser(int idUser) {

        List<PaymentMethod> listPaymentMethod = paymentMethodRepo.findAll();
        List<PaymentMethodDTO> listPaymentMethodDTO = new ArrayList<>();

        for (PaymentMethod paymentMethod: listPaymentMethod) {
            listPaymentMethodDTO.add(converToDTO(paymentMethod));
        }

        return listPaymentMethodDTO;

    }

    @Override
    public PaymentMethodDTO getPaymentDTO(int idPaymentMethod) throws Exception {
        Optional<PaymentMethod> paymentMethodFound = paymentMethodRepo.findById(idPaymentMethod);

        if(paymentMethodFound.isEmpty()){
            throw new Exception("El metodo de pago con id " + idPaymentMethod + " no existe");
        }

        return converToDTO(paymentMethodFound.get());
    }

    @Override
    public PaymentMethod getPayment(int idPaymentMethod) throws Exception {
        Optional<PaymentMethod> paymentMethodFound = paymentMethodRepo.findById(idPaymentMethod);

        if(paymentMethodFound.isEmpty()){
            throw new Exception("El metodo de pago con id " + idPaymentMethod + " no existe");
        }

        return paymentMethodFound.get();
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
