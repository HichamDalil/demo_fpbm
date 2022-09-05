package com.fpbm.pack.repositories;


import com.fpbm.pack.entities.Filiere;
import com.fpbm.pack.entities.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface SemesterRepository extends JpaRepository<Semester, Long> {

    ArrayList<Semester> findByFiliere(Filiere f);
}