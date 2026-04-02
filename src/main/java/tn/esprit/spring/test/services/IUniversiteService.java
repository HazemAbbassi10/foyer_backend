package tn.esprit.spring.test.services;

import tn.esprit.spring.test.entities.Universite;

import java.util.List;

public interface IUniversiteService {
    List<Universite> retrieveAllUniversites();

    Universite retrieveUniversite(Long universiteId);

    Universite addUniversite(Universite u);

    void removeUniversite(Long universiteId);

    Universite modifyUniversite(Universite universite);

    Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite);

    Universite desaffecterFoyerAUniversite(long idUniversite);
}
