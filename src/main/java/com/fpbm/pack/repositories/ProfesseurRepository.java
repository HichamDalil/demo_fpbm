package com.fpbm.pack.repositories;

import com.fpbm.pack.entities.Departement;
import com.fpbm.pack.entities.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Repository
public interface ProfesseurRepository extends JpaRepository<Professeur, Long> {
    ArrayList<Professeur> findByDep(Departement dep);
    @Modifying @Transactional
    @Query(value = "UPDATE `professeur` SET `charge_hor_disponible` = '12' WHERE `professeur`.`id` < 1000",nativeQuery = true)
    void reinstaliser_charge_horaire_dispo();
    @Modifying @Transactional
    @Query(value = "UPDATE `professeur` SET `charge_hor_affecte` = '0' WHERE `professeur`.`id` < 1000",nativeQuery = true)
    void reinstaliser_charge_horaire_affect();

}
