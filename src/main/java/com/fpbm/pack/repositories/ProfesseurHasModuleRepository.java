package com.fpbm.pack.repositories;

import com.fpbm.pack.entities.ProfesseurHasModule;
import com.fpbm.pack.entities.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ProfesseurHasModuleRepository extends JpaRepository<ProfesseurHasModule,Long> {

    ArrayList<ProfesseurHasModule> findBySemester(Semester semester);
}
