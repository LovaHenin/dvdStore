package com.simplon.dvdstore.repositories.client;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ClientRepository  extends CrudRepository<ClientRepositoryModel,Long> {
    ArrayList<ClientRepositoryModel>findAll();
}
