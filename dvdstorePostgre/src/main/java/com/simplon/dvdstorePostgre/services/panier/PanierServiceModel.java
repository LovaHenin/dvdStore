package com.simplon.dvdstorePostgre.services.panier;

import com.simplon.dvdstorePostgre.repositories.panierItem.PanierItemRepositoryModel;
import com.simplon.dvdstorePostgre.services.panierItem.PanierItemServiceModel;

import java.time.LocalDateTime;
import java.util.List;

public record PanierServiceModel(int id,
                                 LocalDateTime createdAt,
                                 Float amount,
                                 int clientId,
                                 // on utilise List<repoModel>
                                 List<PanierItemRepositoryModel> dvds

//                                 List<PanierItemServiceModel>dvds
                                ) {}
