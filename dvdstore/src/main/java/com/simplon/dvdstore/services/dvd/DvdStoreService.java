package com.simplon.dvdstore.services.dvd;

import com.simplon.dvdstore.repositories.dvd.DvdRepositoryModel;
import com.simplon.dvdstore.repositories.dvd.DvdStoreRepository;
import com.simplon.dvdstore.services.dvd.DvdServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class DvdStoreService {
@Autowired
DvdStoreRepository dvdStoreRepository;


public  boolean add( DvdServiceModel dvdServiceModel){
    DvdRepositoryModel dvdRepositoryModel = new DvdRepositoryModel(dvdServiceModel.getName(),dvdServiceModel.getGenre(), dvdServiceModel.getSynopsis(),dvdServiceModel.getQuantite(),dvdServiceModel.getPrix(),dvdServiceModel.getPhoto());

   DvdRepositoryModel dvdRepositoryModelReturned = dvdStoreRepository.save(dvdRepositoryModel);

   return dvdRepositoryModelReturned!=null;
}

public ArrayList<DvdServiceModel> getAll() {
    ArrayList<DvdServiceModel> dvdModelServices = new ArrayList<>();
    ArrayList<DvdRepositoryModel> dvdRepositoryModels = dvdStoreRepository.findAll();

    for(DvdRepositoryModel dvdRepositoryModel :dvdRepositoryModels){
        dvdModelServices.add(new DvdServiceModel(Optional.ofNullable(dvdRepositoryModel.getId()), dvdRepositoryModel.getName(),dvdRepositoryModel.getGenre(), dvdRepositoryModel.getSynopsis(), dvdRepositoryModel.getPrix(),dvdRepositoryModel.getQuantiteStock(),dvdRepositoryModel.getPhoto()));

    }
return dvdModelServices;

}

public Optional<DvdServiceModel> getById(Long id){
    Optional<DvdRepositoryModel> dvdStoreRepositoryResult=dvdStoreRepository.findById(id);

    return Optional.of(new DvdServiceModel(dvdStoreRepositoryResult.get().getName(), dvdStoreRepositoryResult.get().getGenre(),dvdStoreRepositoryResult.get().getSynopsis(), dvdStoreRepositoryResult.get().getPrix(),dvdStoreRepositoryResult.get().getQuantiteStock(),dvdStoreRepositoryResult.get().getPhoto()));

}

    public void deleteById(Long id) {
    dvdStoreRepository.deleteById(id);
    }

    public boolean updateDvd(DvdServiceModel dvdServiceModel) {
    Long id = dvdServiceModel.getId().get();

    if (dvdStoreRepository.existsById(id)){
        DvdRepositoryModel dvdRepositoryModel = new  DvdRepositoryModel(id,dvdServiceModel.getName(),dvdServiceModel.getGenre(),dvdServiceModel.getSynopsis(),dvdServiceModel.getQuantite(),dvdServiceModel.getPrix(),dvdServiceModel.getPhoto());


        Object object = dvdStoreRepository.save(dvdRepositoryModel);

        return true;
    }
        return false;
    }
}
