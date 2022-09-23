package com.fpbm.pack.serviceimpl;

import com.fpbm.pack.entities.Section;
import com.fpbm.pack.entities.Semester;
import com.fpbm.pack.entities.Semester_Section;
import com.fpbm.pack.repositories.Semester_SectionRepository;
import com.fpbm.pack.service.Semester_SectionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Semester_SectionImpl implements Semester_SectionService {

    @Autowired
    private Semester_SectionRepository repo;
    @Override
    public List<Semester_Section> getAll() {
        return repo.findAll();
    }

    @Override
    public Semester_Section save(Semester_Section semester_section) {
        return repo.save(semester_section);
    }

    @Override
    public Optional<Semester_Section> findById(long id) {
        return repo.findById(id);
    }

    @Override
    public Semester_Section update(Semester_Section semester_section, Semester sem, Section sec) {
        semester_section.setSemester(sem);semester_section.setSection(sec);
        return repo.save(semester_section);
    }

    @Override
    public void delete(long id) {repo.deleteById(id); }

    @Override
    public ArrayList<Semester_Section> findBySemester(Semester semester) {
        return repo.findBySemester(semester);
    }
}
