package com.simplon.dvdstore.controllers.vente;

import com.simplon.dvdstore.controllers.client.ClientDTO;
import com.simplon.dvdstore.controllers.dvd.DvdStoreDTO;

public record VentesAfficheDTO(Long id, String date, int quantite, Float prix, DvdStoreDTO dvdStoreDTO, ClientDTO clientDTO) {}
