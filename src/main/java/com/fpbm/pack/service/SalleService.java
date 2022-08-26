package com.fpbm.pack.service;

import com.fpbm.pack.entities.Salle;
import com.fpbm.pack.repositories.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface SalleService {


    public Salle save(Salle salle) ;


    public List<Salle> getAll() ;


    public Salle getOne(Long id) ;


    public Salle update(Salle salle, Long id) ;


    public void delete(Long id) ;
}

