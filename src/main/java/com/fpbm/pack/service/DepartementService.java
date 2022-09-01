package com.fpbm.pack.service;

import com.fpbm.pack.entities.Departement;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface DepartementService {


    public  Departement save(Departement departement);
    public List<Departement> getAll();
    public Departement getOne(Long id) ;


    public Departement update(Departement dep, Long id) ;


    public void delete(Long id) ;

}
