package com.fpbm.pack.service;

import com.fpbm.pack.entities.Salle;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface SalleService {


    public Salle save(Salle salle) ;


    public List<Salle> getAll() ;
    public Salle getByname(String name) ;


    public Salle getOne(Long id) ;


    public Salle update(Salle salle, Long id) ;


    public void delete(Long id) ;
}

