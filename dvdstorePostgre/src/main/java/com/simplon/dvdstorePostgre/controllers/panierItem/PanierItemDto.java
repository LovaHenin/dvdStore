package com.simplon.dvdstorePostgre.controllers.panierItem;

public record PanierItemDto(Integer  panierId, Integer dvdId, Float dvdsPrice, Integer quantity) {}
