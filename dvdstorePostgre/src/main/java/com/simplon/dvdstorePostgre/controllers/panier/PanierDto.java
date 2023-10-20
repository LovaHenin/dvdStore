package com.simplon.dvdstorePostgre.controllers.panier;

import com.simplon.dvdstorePostgre.controllers.panierItem.PanierItemDto;
import com.simplon.dvdstorePostgre.repositories.panierItem.PanierItemRepositoryModel;

import java.time.LocalDateTime;
import java.util.List;

public record PanierDto(int id,
                        LocalDateTime createdAt,
                        Float amount,
                        int clientId,
                        List<PanierItemDto> dvds) {}
