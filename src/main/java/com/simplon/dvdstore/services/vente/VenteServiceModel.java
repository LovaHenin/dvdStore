package com.simplon.dvdstore.services.vente;


import com.simplon.dvdstore.services.client.ClientServiceModel;
import com.simplon.dvdstore.services.dvd.DvdServiceModel;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Optional;

@Service
@Data
public class VenteServiceModel {

    private Optional<Long> id;
    private LocalDate date;
    private float prix;
    private int quantite;

    private Optional<Long> dvd_id;
    private Optional<Long> client_id;

    private Optional<DvdServiceModel> dvdServiceModel;
    private Optional<ClientServiceModel> clientServiceModel;


    public VenteServiceModel() {
    }

    public VenteServiceModel(LocalDate date, int quantite, Optional<Long> dvd_id, Optional<Long> client_id) {
        this.date = date;
        this.quantite = quantite;
        this.dvd_id = dvd_id;
        this.client_id = client_id;
    }

    public VenteServiceModel(LocalDate date, float prix, int quantite, Optional<DvdServiceModel> dvdServiceModel, Optional<ClientServiceModel> clientServiceModel) {
        this.date = date;
        this.prix = prix;
        this.quantite = quantite;
        this.dvdServiceModel = dvdServiceModel;
        this.clientServiceModel = clientServiceModel;
    }
}
