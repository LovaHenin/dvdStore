package com.simplon.dvdstore.repositories.vente;

import ch.qos.logback.core.net.server.Client;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.simplon.dvdstore.repositories.client.ClientRepositoryModel;
import com.simplon.dvdstore.repositories.dvd.DvdRepositoryModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="vente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenteRepositoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   // @CreationTimestamp
    @Column(name="date")
    private LocalDate date;

    @Column(name="prix")
    private float prix;
    // float prix,int quantite,Long dvd_id,Long client_id
    @Column(name="quantite")
    private int quantite;
//    private Long dvd_id;
//    private Long client_id;

    @ManyToOne()
    @JoinColumn(name = "client_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    // pour éviter les boucles infinies lors de la sérialisation
    @JsonIgnore
    private ClientRepositoryModel client;

    @ManyToOne()
    @JoinColumn(name = "dvd_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    // pour éviter les boucles infinies lors de la sérialisation
    @JsonIgnore
    private DvdRepositoryModel dvd;



    public VenteRepositoryModel(LocalDate date, int quantite, float prixtotal, ClientRepositoryModel clientRepositoryModel, DvdRepositoryModel dvdRepositoryModel) {
        this.date=date;
        this.quantite=quantite;
        this.prix=prixtotal;
        this.client=clientRepositoryModel;
        this.dvd=dvdRepositoryModel;
    }


//    @ManyToOne
//    @JoinColumn(name = "dvd_repository_model_id")
//    private DvdRepositoryModel dvdRepositoryModel;


//    @ManyToOne
//    @JoinColumn(name = "client_repository_model_id")
//    private ClientRepositoryModel clientRepositoryModel;

}
