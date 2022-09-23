package com.fpbm.pack.repositories;

import com.fpbm.pack.entities.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SalleRepository extends JpaRepository<Salle, Long> {
    Salle findByName(String name) ;


}