package tn.esprit.spring.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.test.entities.Reservation;
import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, String> {

    @Query("SELECT r FROM Universite u JOIN u.foyer f JOIN f.blocs b JOIN b.chambres c JOIN c.reservations r WHERE u.nomUniversite = :nomUniversite AND YEAR(r.anneeUniversitaire) = YEAR(:anneeUniversite)")
    List<Reservation> getReservationParAnneeUniversitaireEtNomUniversiteJPQL(@Param("anneeUniversite") Date anneeUniversite, @Param("nomUniversite") String nomUniversite);
}
