package com.simplon.dvdstore.controllers.dvd;

import com.simplon.dvdstore.repositories.dvd.DvdRepositoryModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DvdMapper {
    DvdRepositoryModel toDvdRepositoryModel(DvdsStoreDTO dto);

    DvdsStoreDTO toDvdsStoreDTO(DvdRepositoryModel entity);
}
