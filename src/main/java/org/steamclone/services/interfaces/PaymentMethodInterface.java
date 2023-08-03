package org.steamclone.services.interfaces;

import org.steamclone.dtos.PaymentMethodDTO;
import org.steamclone.models.entities.PaymentMethod;

import java.util.List;

public interface PaymentMethodInterface {

    public int createPaymentMethod(PaymentMethodDTO paymentMethodDTO) throws Exception;

    public int updatePaymentMethod(int idPaymentMethod, PaymentMethodDTO paymentMethodDTO) throws Exception;

    public boolean deletePaymentMethod(int idPaymentMethod) throws Exception;

    public List<PaymentMethodDTO> listPaymentMethodUser(int idUser);

    public PaymentMethodDTO getPaymentDTO(int idPaymentMethod) throws Exception;


    public PaymentMethod getPayment(int idPaymentMethod) throws Exception;

}
