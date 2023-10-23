package com.simplon.dvdstore.feignClient;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/panier")
public class FeignClientController {
    private final MicroservicePanierProxy panierProxy;

//    public ClientController(MicroservicePanierProxy panierProxy) {
//        this.panierProxy = panierProxy;
//    }
    @GetMapping
    public List<PanierDto> findAll(){
        return panierProxy.findAll();

    }

}
