package com.fpbm.pack.serviceimpl;

import com.fpbm.pack.entities.Salle;
import com.fpbm.pack.repositories.SalleRepository;
import com.fpbm.pack.service.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class SalleServiceImpl implements SalleService {
    @Autowired
    private SalleRepository salleRepository;

    @Override
    public Salle save(Salle salle) {
        return salleRepository.save(salle);
    }
    @Override
    public ArrayList<Salle> getAll() {return (ArrayList<Salle>)salleRepository.findAll();}
    @Override
    public Salle getByname(String name) {
        return salleRepository.findByName(name);
    }
    @Override
    public Salle getOne(Long id) {
        return salleRepository.findById(id).get();
    }
    @Override
    public Salle update(Salle salle, Long id) { salle.setId(id);return salleRepository.save(salle);}

    @Override
    public void delete(Long id) {
        salleRepository.deleteById(id);
    }

    @Override
    public ArrayList<Salle> findByType_salle(String type_salle){return (ArrayList<Salle>)salleRepository.findByType_salle(type_salle);}
/*
    @Override
    public  List<Salle> findBycapacite(long cp){return salleRepository.findBycapacite(cp);}*/


}
