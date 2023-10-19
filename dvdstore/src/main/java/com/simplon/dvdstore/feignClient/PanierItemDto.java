package com.simplon.dvdstore.feignClient;

public record PanierItemDto(Integer  panierId, Integer dvdId, Float dvdsPrice, Integer quantity) {
}
