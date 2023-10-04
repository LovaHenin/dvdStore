package com.simplon.dvdstore.controllers.vente;

import com.simplon.dvdstore.controllers.client.ClientDTO;
import com.simplon.dvdstore.controllers.dvd.DvdStoreDTO;
import com.simplon.dvdstore.exceptions.ClientNotFoundException;
import com.simplon.dvdstore.services.vente.VenteService;
import com.simplon.dvdstore.services.vente.VenteServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("ventes")
public class VenteController {

    @Autowired
    private VenteService venteService;

    @PostMapping
    public boolean addVente(@RequestBody VenteDTO venteDTO){
        //String date, int quantite,Long dvd_id,Long client_id
        VenteServiceModel venteServiceModel=new VenteServiceModel(LocalDate.parse(venteDTO.date()),venteDTO.quantite(), Optional.ofNullable(venteDTO.dvd_id()), Optional.ofNullable(venteDTO.client_id()));
        return venteService.add(venteServiceModel);
    }
    @GetMapping
    public List<VentesAfficheDTO> getAll(){
    List<VentesAfficheDTO> ventesAfficheDTOS = new ArrayList<>();
    ArrayList<VenteServiceModel>  venteServiceModels = venteService.getAll();

    for(VenteServiceModel venteServiceModel:venteServiceModels){

        DvdStoreDTO dvdStoreDTO = new DvdStoreDTO(venteServiceModel.getDvdServiceModel().get().getName(),venteServiceModel.getDvdServiceModel().get().getGenre(),venteServiceModel.getDvdServiceModel().get().getPrix(), venteServiceModel.getDvdServiceModel().get().getQuantite());

        ClientDTO clientDTO =new ClientDTO(venteServiceModel.getClientServiceModel().get().getNom(),venteServiceModel.getClientServiceModel().get().getAdresse(),venteServiceModel.getClientServiceModel().get().getPhoto());


        ventesAfficheDTOS.add(new VentesAfficheDTO(venteServiceModel.getId().get(), venteServiceModel.getDate().toString(),venteServiceModel.getQuantite(),venteServiceModel.getPrix(),dvdStoreDTO,clientDTO));
    }
    return ventesAfficheDTOS;

    }
    @GetMapping ("/{id}")
    public List<VentesAfficheDTO> getVenteAllByIdClient(@PathVariable("id") Long id){
        List<VentesAfficheDTO> ventesAfficheDTOS = new ArrayList<>();

            ArrayList<VenteServiceModel> venteServiceModels = venteService.getVenteAllByIdClient(id);

            for (VenteServiceModel venteServiceModel : venteServiceModels) {

                DvdStoreDTO dvdStoreDTO = new DvdStoreDTO(venteServiceModel.getDvdServiceModel().get().getName(), venteServiceModel.getDvdServiceModel().get().getGenre(), venteServiceModel.getDvdServiceModel().get().getPrix(), venteServiceModel.getDvdServiceModel().get().getQuantite());

                ClientDTO clientDTO = new ClientDTO(venteServiceModel.getClientServiceModel().get().getNom(), venteServiceModel.getClientServiceModel().get().getAdresse(),venteServiceModel.getClientServiceModel().get().getPhoto());


                ventesAfficheDTOS.add(new VentesAfficheDTO(venteServiceModel.getId().get(), venteServiceModel.getDate().toString(), venteServiceModel.getQuantite(), venteServiceModel.getPrix(), dvdStoreDTO, clientDTO));
            }
            return ventesAfficheDTOS;

    }


}
