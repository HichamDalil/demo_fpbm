package com.fpbm.pack.service;

import com.fpbm.pack.entities.Departement;
import com.fpbm.pack.entities.Professeur;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface ProfesseurService {



    public List<Professeur> getAll() ;
    public Professeur save(Professeur prof) ;

    public Professeur getOne(long id) ;
    public Professeur update(Professeur prof,long id);
    public void delete(long id) ;
    public ArrayList<Professeur> findByDep(Departement dep) ;
}
