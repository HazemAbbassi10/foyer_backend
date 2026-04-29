package tn.esprit.spring.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.test.entities.Chambre;
import tn.esprit.spring.test.entities.TypeChambre;

import java.util.Date;
import java.util.List;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    Chambre findByNumeroChambre(long numeroChambre);

    List<Chambre> findByBlocFoyerUniversiteNomUniversite(String nomUniversite);

    // Solution 1: List des chambres selon bloc et type via Keywords
    List<Chambre> findByBlocIdBlocAndTypeChambre(long idBloc, TypeChambre typeC);

    // Solution 2: List des chambres selon bloc et type via JPQL
    @Query("SELECT c FROM Chambre c WHERE c.bloc.idBloc = :idBloc AND c.typeChambre = :typeC")
    List<Chambre> getChambresParBlocEtTypeJPQL(@Param("idBloc") long idBloc, @Param("typeC") TypeChambre typeC);

    // Keyword: Trouve les chambres de l'université sans AUCUNE réservation dans
    // l'année précisée. (Attention : Keyword n'est pas optimal pour filtrer
    // l'absence dans une collection)
    List<Chambre> findByBlocFoyerUniversiteNomUniversiteAndTypeChambreAndReservationsAnneeUniversitaireNot(
            String nomUniversite, TypeChambre typeChambre, Date anneeUniversitaire);

    // JPQL : Trouve avec une sous-requête les chambres non réservées pour l'année
    // universitaire spécifiée
    @Query("SELECT c FROM Chambre c WHERE c.bloc.foyer.universite.nomUniversite = :nomUniversite AND c.typeChambre = :type AND c.idChambre NOT IN (SELECT ch.idChambre FROM Chambre ch JOIN ch.reservations r WHERE YEAR(r.anneeUniversitaire) = YEAR(:currentDate))")
    List<Chambre> getChambresNonReserveJPQL(@Param("nomUniversite") String nomUniversite,
            @Param("type") TypeChambre type, @Param("currentDate") Date currentDate);

    // JPQL : Chambres non réservées pour l'année en cours — toutes universités confondues
    @Query("SELECT c FROM Chambre c WHERE c.idChambre NOT IN (SELECT ch.idChambre FROM Chambre ch JOIN ch.reservations r WHERE YEAR(r.anneeUniversitaire) = :annee)")
    List<Chambre> getChambresNonReserveePourAnnee(@Param("annee") int annee);
}
