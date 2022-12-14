package com.fpbm.pack.repositories;

import com.fpbm.pack.entities.Module;
import com.fpbm.pack.entities.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {
    ArrayList<Module> findBySemester(Semester s);
}