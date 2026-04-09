package tn.esprit.spring.test.entities;

import jakarta.persistence.*;


import java.util.Date;
import java.util.List;

@Entity

public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long idEtudiant;
    public String nomEt;
    public String prenomEt;
    public long cin;
    public String ecole;
    public Date dateNaissance;

    @ManyToMany(cascade = CascadeType.ALL)
    public List<Reservation> reservations;
}
