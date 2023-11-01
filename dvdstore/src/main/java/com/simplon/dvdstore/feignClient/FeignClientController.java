package com.simplon.dvdstore.feignClient;

import com.simplon.dvdstore.controllers.dvd.DvdsStoreDTO;
import com.simplon.dvdstore.repositories.client.ClientRepository;
import com.simplon.dvdstore.repositories.client.ClientRepositoryModel;
import com.simplon.dvdstore.repositories.dvd.DvdRepositoryModel;
import com.simplon.dvdstore.repositories.dvd.DvdStoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/panier")
public class FeignClientController {
    private final MicroservicePanierProxy panierProxy;
    private final ClientRepository clientRepository;
    private final DvdStoreRepository dvdStoreRepository;

//    public ClientController(MicroservicePanierProxy panierProxy) {
//        this.panierProxy = panierProxy;
//    }
@GetMapping
public List<PanierFinalDto> findAll() {
    List<PanierDto> panierDtos = panierProxy.findAll();
    List<PanierFinalDto> panierFinalDtos = new ArrayList();

    for (PanierDto panierDto : panierDtos) {
        // Retourne le client
        ClientRepositoryModel clientRepositoryModel = clientRepository.findById(panierDto.clientId()).orElse(null);

        List<DvdRepositoryModel> dvdRepositoryModels = new ArrayList(); // Réinitialiser la liste pour chaque client

        for (PanierItemDto dvd : panierDto.dvds()) {
            DvdRepositoryModel dvdRepositoryModel = dvdStoreRepository.findById((long) dvd.dvdId()).orElse(null);
            dvdRepositoryModels.add(
                    new DvdRepositoryModel(
                            dvdRepositoryModel.getName(),
                            dvdRepositoryModel.getGenre(),
                            dvdRepositoryModel.getSynopsis(),
                            dvdRepositoryModel.getQuantiteStock(),
                            dvdRepositoryModel.getPrix(),
                            dvdRepositoryModel.getPhoto()
                    )
            );
        }

        panierFinalDtos.add(
                new PanierFinalDto(
                        panierDto.id(),
                        panierDto.createdAt(),
                        panierDto.amount(),
                        clientRepositoryModel,
                        dvdRepositoryModels
                )
        );
    }

    return panierFinalDtos;
}



}
