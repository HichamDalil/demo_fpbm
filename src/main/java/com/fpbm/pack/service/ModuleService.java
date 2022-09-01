package com.fpbm.pack.service;

import com.fpbm.pack.entities.Module;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ModuleService {



    public List<com.fpbm.pack.entities.Module> getAll() ;
    public Module save(Module module) ;

    public Module getOne(long id) ;
    public Module update(Module mod,long id);

    public void delete(long id) ;
}
