package com.fpbm.pack.repositories;

import com.fpbm.pack.entities.Filiere;
import com.fpbm.pack.entities.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FiliereRepository extends JpaRepository<Filiere, Long> {
}