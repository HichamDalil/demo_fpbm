package com.fpbm.pack.service;

import com.fpbm.pack.entities.Filiere;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface FiliereService {



    public ArrayList<Filiere> getAll() ;
    public Filiere save(Filiere fil) ;

    public Filiere getOne(long id) ;
    public Filiere update(Filiere fil,long id);

    public void delete(long id) ;
    //*************************************

}
