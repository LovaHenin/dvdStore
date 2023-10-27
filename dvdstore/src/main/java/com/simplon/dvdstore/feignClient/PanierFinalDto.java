package com.simplon.dvdstore.feignClient;

import com.simplon.dvdstore.controllers.client.ClientDTO;
import com.simplon.dvdstore.repositories.client.ClientRepository;
import com.simplon.dvdstore.repositories.client.ClientRepositoryModel;
import com.simplon.dvdstore.repositories.dvd.DvdRepositoryModel;

import java.time.LocalDateTime;
import java.util.List;

public record PanierFinalDto(Long id,
                             LocalDateTime createdAt,
                             Float amount,
                             ClientRepositoryModel client,
                             List<DvdRepositoryModel> dvds) {

}
