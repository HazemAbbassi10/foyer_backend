package tn.esprit.spring.test.services;

import tn.esprit.spring.test.entities.Chambre;

import java.util.List;

public interface IChambreService {
    List<Chambre> retrieveAllChambres();

    Chambre retrieveChambre(Long chambreId);

    Chambre addChambre(Chambre c);

    void removeChambre(Long chambreId);

    Chambre modifyChambre(Chambre chambre);
}
