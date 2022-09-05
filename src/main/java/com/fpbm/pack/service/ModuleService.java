package com.fpbm.pack.service;

import com.fpbm.pack.entities.Module;
import com.fpbm.pack.entities.Semester;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public interface ModuleService {



    public List<Module> getAll() ;
    public Module save(Module module) ;

    public Module getOne(long id) ;
    public Module update(Module mod,long id);

    public void delete(long id) ;
    //*************************************************
    ArrayList<Module> findBysemester(Semester s);
}
