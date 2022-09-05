package com.fpbm.pack.serviceimpl;

import com.fpbm.pack.entities.Module;
import com.fpbm.pack.entities.Semester;
import com.fpbm.pack.repositories.ModuleRepository;
import com.fpbm.pack.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.ArrayList;

@Component

public class ModuleServiceImpl implements ModuleService {
 @Autowired
   private ModuleRepository Repo;
    @Override
    public List<Module> getAll() {return Repo.findAll();}
    @Override
    public Module save(Module mod) {return Repo.save(mod);}
    @Override
    public Module getOne(long id) {return Repo.findById(id).get();}
    @Override
    public Module update(Module mod,long id) {mod.setId(id);return Repo.save(mod);}
    @Override
    public void delete(long id) {Repo.deleteById(id);}
 @Override
 public ArrayList<Module> findBysemester(Semester s){return  Repo.findBySemester(s);};
}
