package tn.esprit.spring.test.entities;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.Date;
import java.util.List;

@Entity
public class Reservation {
    @Id
    public String idReservation;
    public Date anneeUniversitaire;
    public Boolean estValide;

    @ManyToMany(mappedBy = "reservations", cascade = CascadeType.ALL)
    @JsonBackReference
    public List<Etudiant> etudiants;
}
