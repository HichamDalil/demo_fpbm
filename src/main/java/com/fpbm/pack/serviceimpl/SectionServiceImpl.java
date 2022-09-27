package com.fpbm.pack.serviceimpl;

import com.fpbm.pack.entities.Section;
import com.fpbm.pack.entities.Semester;
import com.fpbm.pack.repositories.SectionRepository;
import com.fpbm.pack.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class SectionServiceImpl implements SectionService {
    @Autowired
    private SectionRepository Repo;
    @Override
    public Section save(Section s) {
        return Repo.save(s);
    }
    @Override
    public List<Section> getAll() {
        return Repo.findAll();
    }
    @Override
    public Section getOne(Long id) {
        return Repo.findById(id).get();
    }
    @Override
    public Section update(Section s, Long id) { s.setId(id);return Repo.save(s);}
    @Override
    public void delete(Long id) {
        Repo.deleteById(id);
    }
    @Override
    public ArrayList<Section> findbySemester(Semester s) {
        return Repo.findBySemester(s);
    }
}
