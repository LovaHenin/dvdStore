package com.simplon.dvdstorePostgre.controllers.panierItem;

import com.simplon.dvdstorePostgre.repositories.panierItem.PanierItemRepositoryModel;
import com.simplon.dvdstorePostgre.repositories.panierItem.PanierRepositoryModel;
import com.simplon.dvdstorePostgre.services.panierItem.PanierItemServiceModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

@Mapper
public interface PanierItemMapper {
    // Front vers la base
    PanierItemMapper INSTANCE = Mappers.getMapper(PanierItemMapper.class);
    PanierItemServiceModel DtoToservice(PanierItemDto panierItemDto);
//    @Mapping(source = "id", target = "id",qualifiedByName = "optionalToLong")
    PanierItemRepositoryModel serviceToRepository(PanierItemServiceModel panierItemServiceModel);

   // Base vers Front

   PanierItemServiceModel repoToService(PanierItemRepositoryModel panierItemRepositoryModel);

   PanierItemDto serviceToDto(PanierItemServiceModel panierItemServiceModel);

    //transtypage optional => long
    /*@Named("optionalToLong")
    default Long optionalToLong(Optional<Long> id) {
        return id.orElse(null);
    }*/
}
