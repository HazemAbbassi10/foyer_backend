package tn.esprit.spring.test.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.test.entities.Foyer;
import tn.esprit.spring.test.entities.Bloc;
import tn.esprit.spring.test.entities.Universite;
import tn.esprit.spring.test.repositories.FoyerRepository;
import tn.esprit.spring.test.repositories.UniversiteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class FoyerServiceImp implements IFoyerService {
    FoyerRepository foyerRepository;
    UniversiteRepository universiteRepository;

    @Override
    public List<Foyer> retrieveAllFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer retrieveFoyer(Long foyerId) {
        return foyerRepository.findById(foyerId).get();
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public void removeFoyer(Long foyerId) {
        foyerRepository.deleteById(foyerId);
    }

    @Override
    public Foyer modifyFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        // Step 1: add the Foyer with its Blocs
        for (Bloc bloc : foyer.blocs) {
            bloc.setFoyer(foyer);
        }
        Foyer savedFoyer = foyerRepository.save(foyer);

        // Step 2: get the Universite
        Universite universite = universiteRepository.findById(idUniversite).get();

        // Step 3: assign and save
        universite.setFoyer(savedFoyer);
        universiteRepository.save(universite);

        return savedFoyer;
    }
}
