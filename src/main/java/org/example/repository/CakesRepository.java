package org.example.repository;

import org.example.model.Cakes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface CakesRepository extends JpaRepository<Cakes, Long> {
}
