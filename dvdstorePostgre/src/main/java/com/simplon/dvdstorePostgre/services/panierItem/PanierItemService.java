package com.simplon.dvdstorePostgre.services.panierItem;

import com.simplon.dvdstorePostgre.controllers.panierItem.PanierItemMapper;
import com.simplon.dvdstorePostgre.repositories.panierItem.PanierItemRepository;
import com.simplon.dvdstorePostgre.repositories.panierItem.PanierItemRepositoryModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// avec final pour ne pas faire le constructeur
//@RequiredArgsConstructor
@Service
public class PanierItemService {
    @Autowired
    PanierItemRepository panierItemRepository;

    public boolean insererPanierItem(PanierItemServiceModel panierItemServiceModel) {
        PanierItemRepositoryModel panierItemRepositoryModel = PanierItemMapper.INSTANCE.serviceToRepository(panierItemServiceModel);
        PanierItemRepositoryModel panierItemRepositoryModel1 = panierItemRepository.save(panierItemRepositoryModel);
        return panierItemRepositoryModel1!=null;
    }




    // en réalité comme c'est instancier une fois on peut utiliser final
//private final PanierItemRepository panierItemRepository;


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
