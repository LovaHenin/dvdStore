package com.simplon.dvdstore.controllers.dvd;

public record DvdsGetDTO(Long id, String name, String genre,Float prix, int quantite, String photo) {
}
