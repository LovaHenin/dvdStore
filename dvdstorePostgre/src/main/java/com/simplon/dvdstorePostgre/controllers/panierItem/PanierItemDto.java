package com.simplon.dvdstorePostgre.controllers.panierItem;

public record PanierItemDto(Long panierId, Long dvdId, int quantity, Float unitPrice) {}
