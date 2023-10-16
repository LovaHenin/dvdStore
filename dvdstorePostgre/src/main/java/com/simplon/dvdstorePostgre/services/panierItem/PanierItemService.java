package com.simplon.dvdstorePostgre.services.panierItem;

import com.simplon.dvdstorePostgre.controllers.panierItem.PanierItemMapper;
import com.simplon.dvdstorePostgre.repositories.panierItem.PanierItemRepository;
import org.springframework.stereotype.Service;

@Service
public class PanierItemService {
private final PanierItemRepository panierItemRepository;

    public PanierItemService(PanierItemRepository panierItemRepository) {
        this.panierItemRepository = panierItemRepository;
    }

    public boolean insererPanierItem(PanierItemServiceModel panierItemServiceModel) {

        panierItemRepository.insererDansPanierItems(panierItemServiceModel.getPanierId(), panierItemServiceModel.getDvdId(), panierItemServiceModel.getQuantity(), panierItemServiceModel.getUnitPrice());
        return true;
    }
   /*
    PanierItemRepository panierItemRepository;
@PersistenceContext
    private EntityManager entityManager;
    public void insererPanierItem(PanierItemServiceModel panierItemServiceModel) {
        StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("inserer_dans_panier_items");
        query.setParameter("panierId", panierItemServiceModel.getPanierId());
        query.setParameter("dvdId", panierItemServiceModel.getDvdId());
        query.setParameter("quantity", panierItemServiceModel.getQuantity());
        query.setParameter("unitPrice", panierItemServiceModel.getUnitPrice());
        query.execute();
*/

        /*PanierItemRepositoryModel panierItemRepositoryModel = new PanierItemRepositoryModel(panierItemServiceModel.getPanierId(), panierItemServiceModel.getDvdId(), panierItemServiceModel.getQuantity(), panierItemServiceModel.getUnitPrice());

        return panierItemRepositoryModel!=null;
    }*/
}
