package tn.esprit.spring.test.services;

import tn.esprit.spring.test.entities.Chambre;
import tn.esprit.spring.test.entities.TypeChambre;

import java.util.List;

public interface IChambreService {
    List<Chambre> retrieveAllChambres();

    Chambre retrieveChambre(Long chambreId);

    Chambre addChambre(Chambre c);

    void removeChambre(Long chambreId);

    Chambre modifyChambre(Chambre chambre);

    List<Chambre> getChambresParNomUniversite(String nomUniversite);

    List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC);
}
