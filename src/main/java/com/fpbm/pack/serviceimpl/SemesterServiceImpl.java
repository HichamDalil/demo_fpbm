package com.fpbm.pack.serviceimpl;


import com.fpbm.pack.entities.Filiere;
import com.fpbm.pack.entities.Semester;
import com.fpbm.pack.repositories.SemesterRepository;
import com.fpbm.pack.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SemesterServiceImpl implements SemesterService {
    @Autowired
    private SemesterRepository Repo;
    @Override
    public Semester save(Semester s) {
        return Repo.save(s);
    }
    @Override
    public ArrayList<Semester> getAll() {return (ArrayList<Semester>)Repo.findAll();}
    @Override
    public Semester getOne(Long id) {
        return Repo.findById(id).get();
    }
    @Override
    public Semester update(Semester s, Long id) { s.setId(id);return Repo.save(s);}
    @Override
    public void delete(Long id) {
        Repo.deleteById(id);
    }
    @Override
    public ArrayList<Semester> getbyfiliere(Filiere f) {
        return Repo.findByFiliere(f);
    }
}
