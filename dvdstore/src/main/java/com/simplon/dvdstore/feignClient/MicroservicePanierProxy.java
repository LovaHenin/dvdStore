package com.simplon.dvdstore.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="microservice-panier", url="http://localhost:9001/panieritem")
public interface MicroservicePanierProxy {
    @GetMapping
    List<PanierItemDto> findAll();

}
