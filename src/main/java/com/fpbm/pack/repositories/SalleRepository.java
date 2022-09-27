package com.fpbm.pack.repositories;

import com.fpbm.pack.entities.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public interface SalleRepository extends JpaRepository<Salle, Long> {
    Salle findByName(String name) ;
   // @Query("select s from Salle s where s.type_salle =?1")
   List<Salle> findByTypesalle(String typesalle);

    @Query("select s from Salle s where s.capaciteEtudiant >=?1")
    List<Salle> findBycapacite(long cp);

    List<Salle> findBycapaciteEtudiantBetween(long val1,long val2);
}