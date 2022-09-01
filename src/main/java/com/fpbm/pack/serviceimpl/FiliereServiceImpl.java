package com.fpbm.pack.serviceimpl;

import com.fpbm.pack.entities.Filiere;
import com.fpbm.pack.repositories.FiliereRepository;
import com.fpbm.pack.service.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
@Component

public class FiliereServiceImpl implements FiliereService {
 @Autowired
   private FiliereRepository Repo;
    @Override
    public List<Filiere> getAll() {return Repo.findAll();}
    @Override
    public Filiere save(Filiere fil) {return Repo.save(fil);};
    @Override
    public Filiere getOne(long id) {return Repo.findById(id).get();};
    @Override
    public Filiere update(Filiere fil,long id) {fil.setId(id);return Repo.save(fil);};
    @Override
    public void delete(long id) {Repo.deleteById(id);};
}
