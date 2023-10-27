package com.simplon.dvdstorePostgre.services.panier;

import com.simplon.dvdstorePostgre.controllers.panier.PanierMapper;
import com.simplon.dvdstorePostgre.repositories.panierItem.PanierItemRepositoryModel;
import com.simplon.dvdstorePostgre.repositories.panierItem.PanierRepository;
import com.simplon.dvdstorePostgre.repositories.panierItem.PanierRepositoryModel;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PanierService {
    @Autowired
    private PanierRepository panierRepository;

public List<PanierServiceModel> getAll(){
    ArrayList<PanierRepositoryModel> panierRepositoryModel = panierRepository.findAll();
    return panierRepositoryModel.stream().map((value)-> PanierMapper.INSTANCE.repositoryToservice(value)).collect(Collectors.toList());
}

}
