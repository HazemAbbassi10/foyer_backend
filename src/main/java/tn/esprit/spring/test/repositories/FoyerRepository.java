package tn.esprit.spring.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.test.entities.Foyer;

@Repository
public interface FoyerRepository extends JpaRepository<Foyer, Long> {
}
