package org.steamclone.services.interfaces;

import org.steamclone.dtos.PaymentMethodDTO;
import org.steamclone.dtos.UserDTO;
import org.steamclone.models.entities.PaymentMethod;

import java.util.List;

public interface PaymentMethodInterface {

    public int createPaymentMethod(PaymentMethodDTO paymentMethodDTO) throws Exception;

    public int updatePaymentMethod(int idPaymentMethod, PaymentMethodDTO paymentMethodDTO);

    public int deletePaymentMethod(int idPaymentMethod);

    public List<PaymentMethodDTO> listPaymentMethodUser(int idUser);

    public PaymentMethod getPaymentDTO(int idPaymentMethod);

}
