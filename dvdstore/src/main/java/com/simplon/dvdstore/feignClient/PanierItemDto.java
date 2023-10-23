package com.simplon.dvdstore.feignClient;

public record PanierItemDto(Integer  id, Integer dvdId, Float dvdsPrice, Integer quantity) {
}
