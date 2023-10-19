package com.simplon.dvdstore.feignClient;

import com.simplon.dvdstore.controllers.dvd.DvdsGetDTO;

import java.time.LocalDateTime;
import java.util.List;

public record PanierDto(Long id,
                        LocalDateTime createdAt,
                        Float amount,
                        Long clientId,
                        List<DvdsGetDTO> dvds) {}
