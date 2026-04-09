package tn.esprit.spring.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.test.entities.Chambre;
import tn.esprit.spring.test.entities.TypeChambre;

import java.util.List;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    Chambre findByNumeroChambre(long numeroChambre);

    // Solution 1: List des chambres selon bloc et type via Keywords
    List<Chambre> findByBlocIdBlocAndTypeChambre(long idBloc, TypeChambre typeC);

    // Solution 2: List des chambres selon bloc et type via JPQL
    @Query("SELECT c FROM Chambre c WHERE c.bloc.idBloc = :idBloc AND c.typeChambre = :typeC")
    List<Chambre> getChambresParBlocEtTypeJPQL(@Param("idBloc") long idBloc, @Param("typeC") TypeChambre typeC);
}
