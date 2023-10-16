package com.simplon.dvdstorePostgre.controllers.panierItem;

import com.simplon.dvdstorePostgre.repositories.panierItem.PanierItemRepositoryModel;
import com.simplon.dvdstorePostgre.services.panierItem.PanierItemServiceModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PanierItemMapper {
    PanierItemMapper INSTANCE = Mappers.getMapper(PanierItemMapper.class);
    PanierItemServiceModel PanierItemDtoToPanierItemService(PanierItemDto panierItemDto);
    PanierItemRepositoryModel ServiceToRepository(PanierItemServiceModel panierItemServiceModel);


}
