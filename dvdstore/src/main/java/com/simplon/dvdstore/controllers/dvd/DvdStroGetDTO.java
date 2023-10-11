package com.simplon.dvdstore.controllers.dvd;

public record DvdStroGetDTO(Long id, String name, String genre, String synopsis, Float prix, int quantite, String photo) {}
