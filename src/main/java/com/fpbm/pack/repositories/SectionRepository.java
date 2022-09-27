package com.fpbm.pack.repositories;
import com.fpbm.pack.entities.Filiere;
import com.fpbm.pack.entities.Section;
import com.fpbm.pack.entities.Semester;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface SectionRepository extends JpaRepository<Section, Long> {

    ArrayList<Section> findBySemester(Semester s);
}
