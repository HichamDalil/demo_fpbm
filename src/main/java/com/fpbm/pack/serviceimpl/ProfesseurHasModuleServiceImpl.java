package com.fpbm.pack.serviceimpl;

import com.fpbm.pack.entities.ProfesseurHasModule;
import com.fpbm.pack.entities.Semester;
import com.fpbm.pack.repositories.ProfesseurHasModuleRepository;
import com.fpbm.pack.service.ProfesseurHasModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ProfesseurHasModuleServiceImpl implements ProfesseurHasModuleService {
    @Autowired
    private ProfesseurHasModuleRepository Repo;
    @Override
    public List<ProfesseurHasModule> getAll() {return Repo.findAll();}

    @Override
    public ProfesseurHasModule save(ProfesseurHasModule profHasModule) {return Repo.save(profHasModule);  }

    @Override
    public ProfesseurHasModule getOne(long id) {return Repo.findById(id).get();}

    @Override
    public ProfesseurHasModule update(ProfesseurHasModule profHasModule, long id) {return null; }

    @Override
    public void delete(long id) {}
    //-------------------------------
    public ArrayList<ProfesseurHasModule> findBySemester(Semester semester){return Repo.findBySemester(semester);}
}
