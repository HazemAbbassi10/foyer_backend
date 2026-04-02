package tn.esprit.spring.test.services;

import tn.esprit.spring.test.entities.Reservation;

import java.util.List;

public interface IReservationService {
    List<Reservation> retrieveAllReservations();

    Reservation retrieveReservation(String reservationId);

    Reservation addReservation(Reservation r);

    void removeReservation(String reservationId);

    Reservation modifyReservation(Reservation reservation);
}
