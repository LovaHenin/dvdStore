package com.simplon.dvdstore.controllers.dvd;

public record DvdsGetDTO(Long id, String name, String genre,String synopsis, Float prix, int quantite, String photo) {
}
