package tn.esprit.spring.test.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.spring.test.entities.Chambre;
import tn.esprit.spring.test.entities.TypeChambre;
import tn.esprit.spring.test.repositories.ChambreRepository;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class ChambreServiceImp implements IChambreService {
    ChambreRepository chambreRepository;

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
        return chambreRepository.findByBlocFoyerUniversiteNomUniversite(nomUniversite);
    }

    @Override
    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre type) {
        Date anneeActuelle = new Date();
        return chambreRepository.getChambresNonReserveJPQL(nomUniversite, type, anneeActuelle);
    }

    @Override
    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC) {
        // Solution 1 : Utilisation des Keywords
        return chambreRepository.findByBlocIdBlocAndTypeChambre(idBloc, typeC);

        // Solution 2 : Utilisation de JPQL
        // return chambreRepository.getChambresParBlocEtTypeJPQL(idBloc, typeC);
    }

    // Runs every day at midnight: 0 seconds, 0 minutes, 0 hours
    @Scheduled(cron = "0 0 0 * * *")
    public void afficherChambresNonReserveesAnneeEnCours() {
        int anneeEnCours = LocalDate.now().getYear();
        List<Chambre> chambres = chambreRepository.getChambresNonReserveePourAnnee(anneeEnCours);
        log.info("=== Chambres non réservées pour l'année {} (toutes universités) ===", anneeEnCours);
        chambres.forEach(c -> log.info("Chambre ID: {}, Numéro: {}, Type: {}",
                c.getIdChambre(), c.getNumeroChambre(), c.getTypeChambre()));
        log.info("Total: {} chambre(s) non réservée(s)", chambres.size());
    }
}
