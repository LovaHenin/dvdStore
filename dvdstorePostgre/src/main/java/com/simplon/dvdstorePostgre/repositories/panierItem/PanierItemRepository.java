package com.simplon.dvdstorePostgre.repositories.panierItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PanierItemRepository extends JpaRepository<PanierItemRepositoryModel,Long> {
    @Query(value = "CALL inserer_dans_panier_items(:panierId, :dvdId, :quantity, :unitPrice)", nativeQuery = true)
    void insererDansPanierItems(@Param("panierId") Long panierId, @Param("dvdId") Long dvdId, @Param("quantity") int quantity, @Param("unitPrice") Float unitPrice);

}
