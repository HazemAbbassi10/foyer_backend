package tn.esprit.spring.test.services;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import tn.esprit.spring.test.entities.Reservation;
import tn.esprit.spring.test.repositories.ReservationRepository;
import tn.esprit.spring.test.repositories.UniversiteRepository;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ReservationServiceImp implements IReservationService {
    ReservationRepository reservationRepository;
    UniversiteRepository universiteRepository;

    @Override
    public List<Reservation> retrieveAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation retrieveReservation(String reservationId) {
        return reservationRepository.findById(reservationId).get();
    }

    @Override
    public Reservation addReservation(Reservation r) {
        return reservationRepository.save(r);
    }

    @Override
    public void removeReservation(String reservationId) {
        reservationRepository.deleteById(reservationId);
    }

    @Override
    public Reservation modifyReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversite, String nomUniversite) {
        // We use the incredibly powerful JPQL query to instantly fetch what we need without loops!
        return reservationRepository.getReservationParAnneeUniversitaireEtNomUniversiteJPQL(anneeUniversite, nomUniversite);
    }
}
