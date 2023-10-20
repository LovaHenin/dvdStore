package com.simplon.dvdstorePostgre.controllers.panier;

import com.simplon.dvdstorePostgre.repositories.panierItem.PanierRepositoryModel;
import com.simplon.dvdstorePostgre.services.panier.PanierServiceModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PanierMapper {
    PanierMapper INSTANCE= Mappers.getMapper(PanierMapper.class);
    //Front vers la base

    // Base vesr Front
    PanierServiceModel repositoryToservice(PanierRepositoryModel panierRepositoryModel);
    PanierDto serviToDto(PanierServiceModel panierServiceModel);

}
