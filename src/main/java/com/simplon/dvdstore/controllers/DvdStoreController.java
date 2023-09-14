package com.simplon.dvdstore.controllers;

import com.simplon.dvdstore.repositories.DvdRepositoryModel;
import com.simplon.dvdstore.services.DvdServiceModel;
import com.simplon.dvdstore.services.DvdStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public  boolean addDvdToStore(@RequestBody DvdStoreDTO dvdStoreDTO){
        DvdServiceModel dvdServiceModel = new DvdServiceModel(dvdStoreDTO.name(), dvdStoreDTO.genre());

       return dvdStoreService.add(dvdServiceModel);

    }
    @GetMapping
    public List<DvdStoreDTO> getAll(){

        ArrayList<DvdStoreDTO> dvdStoreDTOS = new ArrayList<DvdStoreDTO>();

        ArrayList<DvdServiceModel> dvdServiceModelArrayList =  dvdStoreService.getAll();

        for(DvdServiceModel x: dvdServiceModelArrayList){
            dvdStoreDTOS.add(new DvdStoreDTO(x.getName(),x.getGenre()));
        }

        return dvdStoreDTOS;
    }
    @GetMapping("/{id}")
    public DvdStoreDTO getById(@PathVariable("id") Long number){

       DvdStoreDTO dvdStoreDTO = new DvdStoreDTO(dvdStoreService.getById(number).get().getName(),dvdStoreService.getById(number).get().getGenre());

            return dvdStoreDTO;

        }
        @DeleteMapping("/{id}")
        public void deleteDvd(@PathVariable Long id){
        dvdStoreService.deleteById(id);
        }


    @PutMapping("/{id}")
    public boolean updateDvd(@PathVariable Long id, @RequestBody DvdStroGetDTO dvdStroGetDTO) {

        DvdServiceModel dvdServiceModel = new DvdServiceModel(Optional.ofNullable(id),dvdStroGetDTO.name(),dvdStroGetDTO.genre());
      return   dvdStoreService.updateDvd(dvdServiceModel);


        }
    }






