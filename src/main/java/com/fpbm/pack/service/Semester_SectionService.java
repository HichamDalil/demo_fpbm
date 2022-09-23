package com.fpbm.pack.service;
import com.fpbm.pack.entities.Section;
import com.fpbm.pack.entities.Semester;
import com.fpbm.pack.entities.Semester_Section;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface Semester_SectionService {
    public List<Semester_Section> getAll() ;
    public Semester_Section save(Semester_Section semester_section) ;

    public Optional<Semester_Section> findById(long id) ;
    public Semester_Section update(Semester_Section semester_section, Semester sem, Section sec);
    public void delete(long id) ;
    public ArrayList<Semester_Section> findBySemester(Semester semester) ;
}
