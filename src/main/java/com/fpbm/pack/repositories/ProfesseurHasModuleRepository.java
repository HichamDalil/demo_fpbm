package com.fpbm.pack.repositories;

import com.fpbm.pack.entities.ProfesseurHasModule;
import com.fpbm.pack.entities.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Repository
public interface ProfesseurHasModuleRepository extends JpaRepository<ProfesseurHasModule,Long> {

    ArrayList<ProfesseurHasModule> findBySemester(Semester semester);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `professeur_has_module` WHERE `professeur_has_module`.`id` <1000",nativeQuery = true)
    void deleteall();
    @Modifying @Transactional
    @Query(value = "ALTER TABLE `professeur_has_module` auto_increment = 1",nativeQuery = true)
    void auto_increment_to_one();
}
