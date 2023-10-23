package com.simplon.dvdstore.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
//le nom à mettre dans l'application.properties du back2
@FeignClient(name="microservice-panier", url="http://localhost:9001/api/panier")
public interface MicroservicePanierProxy {
    @GetMapping
    List<PanierDto> findAll();

}
