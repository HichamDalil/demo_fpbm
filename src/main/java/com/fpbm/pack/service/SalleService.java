package com.fpbm.pack.service;

import com.fpbm.pack.entities.Salle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface SalleService {


    public Salle save(Salle salle) ;


    public ArrayList<Salle> getAll() ;
    public Salle getByname(String name) ;


    public Salle getOne(Long id) ;


    public Salle update(Salle salle, Long id) ;


    public void delete(Long id) ;

    public List<Salle> findByTypesalle(String typesalle);
    List<Salle> findBycapaciteEtudiantBetween(int val1,int val2);

    /*    public List<Salle> findBycapacite(long cp);*/
}

