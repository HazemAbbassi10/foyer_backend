package tn.esprit.spring.test.entities;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;

@Entity
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long idFoyer;
    public String nomFoyer;
    public long capacityFoyer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "foyer")
    @JsonManagedReference("foyer-bloc")
    public List<Bloc> blocs;

    @OneToOne(mappedBy = "foyer")
    @JsonBackReference("foyer-universite")
    public Universite universite;

}
