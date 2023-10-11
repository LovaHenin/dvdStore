package com.simplon.dvdstore.repositories.dvd;

import com.simplon.dvdstore.repositories.dvd.DvdRepositoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface DvdStoreRepository extends JpaRepository<DvdRepositoryModel,Long> {

   // DvdRepositoryModel save(DvdRepositoryModel dvdRepositoryModel);
    //DvdRepositoryModel dvdRepo= new DvdRepositoryModel();

   ArrayList<DvdRepositoryModel> findAll();



}
