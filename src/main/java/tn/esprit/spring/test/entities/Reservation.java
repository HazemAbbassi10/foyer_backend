package tn.esprit.spring.test.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Reservation {
    @Id
    public String idReservation;
    public Date anneeUniversitaire;
    public Boolean estValide;

    @ManyToMany(mappedBy = "reservations",cascade = CascadeType.ALL)
    public List<Etudiant> etudiants;
}
