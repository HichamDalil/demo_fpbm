package com.fpbm.pack.repositories;

import com.fpbm.pack.entities.Departement;
import com.fpbm.pack.entities.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ProfesseurRepository extends JpaRepository<Professeur, Long> {
    ArrayList<Professeur> findByDep(Departement dep);
}
