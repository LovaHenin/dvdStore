package com.simplon.dvdstore.controllers;

//import lombok.Data;

//@Data
//public class DvdStoreDTO {
//    private String name;
//    private String genre;
//}

import lombok.Value;

public record DvdStoreDTO(String name, String genre) {}