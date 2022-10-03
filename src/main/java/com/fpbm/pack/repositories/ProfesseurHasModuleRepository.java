package com.fpbm.pack.repositories;

import com.fpbm.pack.entities.ProfesseurHasModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesseurHasModuleRepository extends JpaRepository<ProfesseurHasModule,Long> {
}
