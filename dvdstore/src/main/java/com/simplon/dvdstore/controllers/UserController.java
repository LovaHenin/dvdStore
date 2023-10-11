package com.simplon.dvdstore.controllers;

import com.simplon.dvdstore.services.impl.JwtUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Me")
public class UserController {
    @Autowired
    private JwtUserService jwtUserService;
@GetMapping
    public ResponseEntity<UserProfileDto> getCurrentUser(){
// Obtenir l'utilisateur actuellement authentifié
        UserDetails currentUser = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        // Créer un DTO (Data Transfer Object) pour le profil utilisateur
        UserProfileDto userProfile = new UserProfileDto(currentUser.getUsername(), currentUser.getAuthorities());

        // Renvoyer le profil utilisateur en réponse
        return ResponseEntity.ok(userProfile);


    }
}
