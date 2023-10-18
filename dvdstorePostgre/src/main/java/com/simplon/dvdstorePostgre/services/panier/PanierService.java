package com.simplon.dvdstorePostgre.services.panier;

import com.simplon.dvdstorePostgre.repositories.panierItem.PanierRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

/*@Service
public class PanierService {
    @Autowired
    private PanierRepository panierRepository;

    @Transactional
    @Modifying
    public boolean mettreAJourMontantPanier(Integer panierId) {
        panierRepository.updatePanierAmount(panierId);
        return true;
    }
}*/
