package com.simplon.dvdstore.controllers.vente;

import java.math.BigDecimal;
import java.time.LocalDate;

// POST
public record VenteDTO(float prix,int quantite,Long dvd_id,Long client_id) {}
