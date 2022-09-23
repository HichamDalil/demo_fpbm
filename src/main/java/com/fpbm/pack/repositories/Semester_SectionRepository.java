package com.fpbm.pack.repositories;
import com.fpbm.pack.entities.Semester;
import com.fpbm.pack.entities.Semester_Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public interface Semester_SectionRepository extends JpaRepository<Semester_Section, Long> {
    ArrayList<Semester_Section> findBySemester(Semester semester);
}
