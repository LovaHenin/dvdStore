package com.simplon.dvdstore.controllers;

import com.simplon.dvdstore.controllers.client.ClientAfficheDTO;
import com.simplon.dvdstore.controllers.client.ClientController;
import com.simplon.dvdstore.controllers.client.ClientDTO;
import com.simplon.dvdstore.controllers.dvd.DvdStoreController;
import com.simplon.dvdstore.controllers.dvd.DvdStroGetDTO;
import com.simplon.dvdstore.controllers.dvd.DvdsGetDTO;
import com.simplon.dvdstore.controllers.dvd.DvdsStoreDTO;
import com.simplon.dvdstore.controllers.vente.VenteController;
import com.simplon.dvdstore.controllers.vente.VenteDTO;
import com.simplon.dvdstore.controllers.vente.VentesAfficheDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@PreAuthorize("hasAuthority('admin')")
@RestController
@RequestMapping("/api") // Préfixe commun pour toutes les routes
public class ApiControler {

    @Autowired
    private DvdStoreController dvdStoreController;

    @Autowired
    private ClientController clientController;

    @Autowired
    private VenteController venteController;

    // Routes pour les DVDs
    @PostMapping("/dvds")
    public boolean addDvdToStore(@RequestBody DvdsStoreDTO dvdsStoreDTO) {
        return dvdStoreController.addDvdToStore(dvdsStoreDTO);
    }

    @GetMapping("/dvds")
    public List<DvdsGetDTO> getAllDvds() {
        return dvdStoreController.getAll();
    }

    @GetMapping("/dvds/{id}")
    public DvdStroGetDTO getDvdById(@PathVariable("id") Long number) {
        return dvdStoreController.getById(number);
    }

    @DeleteMapping("/dvds/{id}")
    public void deleteDvd(@PathVariable Long id) {
        dvdStoreController.deleteDvd(id);
    }

    @PutMapping("/dvds/{id}")
    public boolean updateDvd(@PathVariable Long id, @RequestBody DvdsGetDTO dvdsGetDTO) {
        return dvdStoreController.updateDvd(id, dvdsGetDTO);
    }

    // Routes pour les clients
    @PostMapping("/clients")
    public boolean ajoutClient(@RequestBody ClientDTO clientDTO) {
        return clientController.ajoutClient(clientDTO);
    }

    @GetMapping("/clients")
    public List<ClientAfficheDTO> getAllClients() {
        return clientController.getAll();
    }

    @GetMapping("/clients/{id}")
    public ClientAfficheDTO getClientById(@PathVariable("id") Long id) {
        return clientController.getById(id);
    }

    // Routes pour les ventes
    @PostMapping("/ventes")
    public boolean addVente(@RequestBody VenteDTO venteDTO) {
        return venteController.addVente(venteDTO);
    }

    @GetMapping("/ventes")
    public List<VentesAfficheDTO> getAllVentes() {
        return venteController.getAll();
    }

    @GetMapping("/ventes/{id}")
    public List<VentesAfficheDTO> getVentesByClientId(@PathVariable("id") Long id) {
        return venteController.getVenteAllByIdClient(id);
    }
}
