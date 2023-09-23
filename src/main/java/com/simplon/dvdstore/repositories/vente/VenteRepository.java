package com.simplon.dvdstore.repositories.vente;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public interface VenteRepository extends JpaRepository<VenteRepositoryModel,Long> {
 //   ArrayList<VenteRepositoryModel>  findByClientId(Long postId);
// pour eviter de caster venteRepo.findAll dans service
    ArrayList<VenteRepositoryModel>findAll();
    ArrayList<VenteRepositoryModel> findByClientId(Long clientId);


}
