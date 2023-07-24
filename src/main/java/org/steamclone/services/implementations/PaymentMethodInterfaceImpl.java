package org.steamclone.services.implementations;

import org.springframework.stereotype.Service;
import org.steamclone.dtos.PaymentMethodDTO;
import org.steamclone.models.entities.PaymentMethod;
import org.steamclone.services.interfaces.PaymentMethodInterface;

import java.util.List;

@Service
public class PaymentMethodInterfaceImpl implements PaymentMethodInterface {
    @Override
    public int createPaymentMethod(PaymentMethod paymentMethod) {
        return 0;
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


        );
    }
}
