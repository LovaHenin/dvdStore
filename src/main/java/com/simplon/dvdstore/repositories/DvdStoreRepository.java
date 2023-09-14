package com.simplon.dvdstore.repositories;

import com.simplon.dvdstore.services.DvdServiceModel;
import org.hibernate.annotations.OnDelete;
import org.hibernate.sql.Update;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface DvdStoreRepository extends CrudRepository<DvdRepositoryModel,Long> {

   // DvdRepositoryModel save(DvdRepositoryModel dvdRepositoryModel);
    DvdRepositoryModel dvdRepo= new DvdRepositoryModel();

   ArrayList<DvdRepositoryModel> findAll();



}
