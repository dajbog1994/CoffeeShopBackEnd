package org.example.repository;

import org.example.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface CoffeRepository  extends JpaRepository<Coffee,Long> {

}
