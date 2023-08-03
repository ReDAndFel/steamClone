package org.steamclone.services.interfaces;

import org.steamclone.dtos.BusinessDTO;
import org.steamclone.models.entities.Business;

import java.util.List;


public interface BusinessInterface {

    public int createBusiness(BusinessDTO businessDTO) throws Exception;
    public int updateBusiness(int id, BusinessDTO businessDTO) throws Exception;
    public boolean deleteBusiness(int id) throws Exception;
    List<BusinessDTO> listByName(String name);
    List<BusinessDTO> listByIdGame(int idGame);
    List<BusinessDTO> listByBusinessType(int businessType);
    public BusinessDTO getBusinessDTO(int idBusiness);
    public Business getBusiness(int idBusiness);



}
