package tn.esprit.spring.test.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long idFoyer;
    public String nomFoyer;
    public long capacityFoyer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "foyer")
    public List<Bloc> blocs;

    @OneToOne(mappedBy = "foyer")
    public Universite universite;

}
