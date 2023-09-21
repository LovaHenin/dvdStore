package com.simplon.dvdstore.services.vente;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
@Service
@Data
@AllArgsConstructor
public class VenteServiceModel {

    private Optional<Long> id;
    private LocalDate date;
    private float prix;
    private int quantite;

    private Long dvd_id;
    private  Long client_id;

    public VenteServiceModel() {
    }

    public VenteServiceModel(LocalDate date, int quantite, Long dvd_id, Long client_id) {
        this.date = date;
        this.quantite = quantite;
        this.dvd_id = dvd_id;
        this.client_id = client_id;
    }


}
