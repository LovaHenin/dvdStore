package com.simplon.dvdstore.controllers;

import com.simplon.dvdstore.repositories.DvdRepositoryModel;
import com.simplon.dvdstore.services.DvdServiceModel;
import com.simplon.dvdstore.services.DvdStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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



}
