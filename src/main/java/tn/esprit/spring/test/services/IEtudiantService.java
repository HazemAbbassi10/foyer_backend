package tn.esprit.spring.test.services;

import tn.esprit.spring.test.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
    List<Etudiant> retrieveAllEtudiants();

    Etudiant retrieveEtudiant(Long etudiantId);

    Etudiant addEtudiant(Etudiant e);

    void removeEtudiant(Long etudiantId);

    Etudiant modifyEtudiant(Etudiant etudiant);
}
