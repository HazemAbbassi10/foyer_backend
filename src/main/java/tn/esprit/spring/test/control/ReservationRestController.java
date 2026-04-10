package tn.esprit.spring.test.control;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.test.entities.Reservation;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import tn.esprit.spring.test.services.IReservationService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationRestController {
    IReservationService reservationService;

    @GetMapping("/retrieve-all-reservations")
    public List<Reservation> getAllReservations() {
        return reservationService.retrieveAllReservations();
    }

    @GetMapping("/retrieve-reservation/{reservation-id}")
    public Reservation retrieveReservation(@PathVariable("reservation-id") String reservationId) {
        return reservationService.retrieveReservation(reservationId);
    }

    @PostMapping("/add-reservation")
    public Reservation addReservation(@RequestBody Reservation r) {
        return reservationService.addReservation(r);
    }

    @DeleteMapping("/remove-reservation/{reservation-id}")
    public void removeReservation(@PathVariable("reservation-id") String reservationId) {
        reservationService.removeReservation(reservationId);
    }

    @PutMapping("/modify-reservation")
    public Reservation modifyReservation(@RequestBody Reservation r) {
        return reservationService.modifyReservation(r);
    }

    @GetMapping("/reservations-par-annee-universite/{nomUniversite}")
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(
            @RequestParam("anneeUniversite") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date anneeUniversite, 
            @PathVariable("nomUniversite") String nomUniversite) {
        return reservationService.getReservationParAnneeUniversitaireEtNomUniversite(anneeUniversite, nomUniversite);
    }
}
