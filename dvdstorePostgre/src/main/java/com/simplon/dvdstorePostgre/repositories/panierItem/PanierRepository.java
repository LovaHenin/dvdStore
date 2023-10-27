package com.simplon.dvdstorePostgre.repositories.panierItem;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PanierRepository extends JpaRepository<PanierRepositoryModel, Long> {

    @Query(value = "CALL update_panier_amount(:id_pan)", nativeQuery = true)
    String updatePanierAmount(int id_pan);

    ArrayList<PanierRepositoryModel> findAll();

}
