package tn.esprit.spring.test.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.test.entities.Chambre;
import tn.esprit.spring.test.entities.Bloc;
import tn.esprit.spring.test.entities.TypeChambre;
import tn.esprit.spring.test.entities.Universite;
import tn.esprit.spring.test.repositories.ChambreRepository;
import tn.esprit.spring.test.repositories.UniversiteRepository;
import java.util.ArrayList;

import java.util.List;

@Service
@AllArgsConstructor
public class ChambreServiceImp implements IChambreService {
    ChambreRepository chambreRepository;
    UniversiteRepository universiteRepository;

    @Override
    public List<Chambre> retrieveAllChambres() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre retrieveChambre(Long chambreId) {
        return chambreRepository.findById(chambreId).get();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public void removeChambre(Long chambreId) {
        chambreRepository.deleteById(chambreId);
    }

    @Override
    public Chambre modifyChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public List<Chambre> getChambresParNomUniversite(String nomUniversite) {
        Universite universite = universiteRepository.findByNomUniversite(nomUniversite);
        List<Chambre> chambres = new ArrayList<>();

        if (universite != null && universite.getFoyer() != null && universite.getFoyer().blocs != null) {
            for (Bloc bloc : universite.getFoyer().blocs) {
                if (bloc.getChambres() != null) {
                    chambres.addAll(bloc.getChambres());
                }
            }
        }

        return chambres;
    }

    @Override
    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC) {
        // Solution 1 : Utilisation des Keywords
        return chambreRepository.findByBlocIdBlocAndTypeChambre(idBloc, typeC);
        
        // Solution 2 : Utilisation de JPQL
        // return chambreRepository.getChambresParBlocEtTypeJPQL(idBloc, typeC);
    }
}
