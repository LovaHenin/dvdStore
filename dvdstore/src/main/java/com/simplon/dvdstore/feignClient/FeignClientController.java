package com.simplon.dvdstore.feignClient;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/panieritem")
public class FeignClientController {
    private final MicroservicePanierProxy panierProxy;

//    public ClientController(MicroservicePanierProxy panierProxy) {
//        this.panierProxy = panierProxy;
//    }
    @GetMapping
    public List<PanierItemDto> findAll(){
        return panierProxy.findAll();

    }

}
