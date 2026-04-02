package tn.esprit.spring.test.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.test.entities.Bloc;
import tn.esprit.spring.test.entities.Chambre;
import tn.esprit.spring.test.repositories.BlocRepository;
import tn.esprit.spring.test.repositories.ChambreRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class BlocServiceImp implements IBlocService {
    BlocRepository blocRepository;
    ChambreRepository chambreRepository;

    @Override
    public List<Bloc> retrieveAllBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc retrieveBloc(Long blocId) {
        return blocRepository.findById(blocId).get();
    }

    @Override
    public Bloc addBloc(Bloc c) {
        return blocRepository.save(c);
    }

    @Override
    public void removeBloc(Long blocId) {
        blocRepository.deleteById(blocId);
    }

    @Override
    public Bloc modifyBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {

        Bloc bloc = blocRepository.findById(idBloc).get();

        for (Long num : numChambre) {
            Chambre chambre = chambreRepository.findByNumeroChambre(num);
            chambre.setBloc(bloc);
            chambreRepository.save(chambre);
        }
        return bloc;
    }
}
