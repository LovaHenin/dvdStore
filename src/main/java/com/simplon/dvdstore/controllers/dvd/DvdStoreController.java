package com.simplon.dvdstore.controllers.dvd;

import com.simplon.dvdstore.services.dvd.DvdServiceModel;
import com.simplon.dvdstore.services.dvd.DvdStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("dvds")
public class DvdStoreController {
    @Autowired
    DvdStoreService dvdStoreService;

    @PostMapping
    public  boolean addDvdToStore(@RequestBody DvdsStoreDTO dvdsStoreDTO){
        DvdServiceModel dvdServiceModel = new DvdServiceModel(dvdsStoreDTO.name(), dvdsStoreDTO.genre(),dvdsStoreDTO.prix(),dvdsStoreDTO.quantite(),dvdsStoreDTO.photo());

       return dvdStoreService.add(dvdServiceModel);

    }
    @GetMapping
    public List<DvdsStoreDTO> getAll(){

        ArrayList<DvdsStoreDTO> dvdsStoreDTOS = new ArrayList<DvdsStoreDTO>();

        ArrayList<DvdServiceModel> dvdServiceModelArrayList =  dvdStoreService.getAll();

        for(DvdServiceModel x: dvdServiceModelArrayList){
            dvdsStoreDTOS.add(new DvdsStoreDTO(x.getName(),x.getGenre(), x.getPrix(), x.getQuantite(), x.getPhoto()));
        }

        return dvdsStoreDTOS;
    }
    @GetMapping("/{id}")
    public DvdsStoreDTO getById(@PathVariable("id") Long number){

       DvdsStoreDTO dvdsStoreDTO = new DvdsStoreDTO(dvdStoreService.getById(number).get().getName(),dvdStoreService.getById(number).get().getGenre(),dvdStoreService.getById(number).get().getPrix(),dvdStoreService.getById(number).get().getQuantite(),dvdStoreService.getById(number).get().getPhoto());

            return dvdsStoreDTO;

        }
        @DeleteMapping("/{id}")
        public void deleteDvd(@PathVariable Long id){
        dvdStoreService.deleteById(id);
        }


    @PutMapping("/{id}")
    public boolean updateDvd(@PathVariable Long id, @RequestBody DvdsGetDTO dvdsGetDTO) {

        DvdServiceModel dvdServiceModel = new DvdServiceModel(Optional.ofNullable(id),dvdsGetDTO.name(),dvdsGetDTO.genre(),dvdsGetDTO.prix(),dvdsGetDTO.quantite(),dvdsGetDTO.photo());
      return   dvdStoreService.updateDvd(dvdServiceModel);


        }
    }






