package com.fpbm.pack.service;
import com.fpbm.pack.entities.ProfesseurHasModule;
import com.fpbm.pack.entities.Semester;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface ProfesseurHasModuleService {
    public List<ProfesseurHasModule> getAll() ;
    public ProfesseurHasModule save(ProfesseurHasModule profHasModule) ;
    public ProfesseurHasModule getOne(long id) ;
    public ProfesseurHasModule update(ProfesseurHasModule profHasModule,long id);
    public void delete(long id) ;
    //-----------------------------------
    public ArrayList<ProfesseurHasModule> findBySemester(Semester semester);
}
