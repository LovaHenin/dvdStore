package com.simplon.dvdstore.controllers.dvd;

//import lombok.Data;

//@Data
//public class DvdStoreDTO {
//    private String name;
//    private String genre;
//}

import ch.qos.logback.core.joran.conditional.PropertyEvalScriptBuilder;
import lombok.Value;

public record DvdStoreDTO(String name, String genre) {}
