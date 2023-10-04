package com.simplon.dvdstore.controllers.client;

import com.simplon.dvdstore.services.client.ClientServiceModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper( ClientMapper.class );

   ClientServiceModel ClientDtoToClientService(ClientDTO clientDTO);
    @Mapping(source = "id", target = "id",qualifiedByName = "optionalToLong")
    ClientAfficheDTO ClientServiceToClientDto(ClientServiceModel clientServiceModel);

    @Named("optionalToLong")
    default Long optionalToLong(Optional<Long> id) {
        return id.orElse(null);
    }
}
