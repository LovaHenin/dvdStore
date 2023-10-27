package com.simplon.dvdstorePostgre.repositories.panierItem;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PanierItemRepository extends JpaRepository<PanierItemRepositoryModel,Long> {

ArrayList<PanierItemRepositoryModel>findAll();



}
