package com.fpbm.pack.serviceimpl;

import com.fpbm.pack.entities.Departement;
import com.fpbm.pack.entities.Professeur;
import com.fpbm.pack.repositories.ProfesseurRepository;
import com.fpbm.pack.service.ProfesseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProfesseurServiceImpl implements ProfesseurService {
    @Autowired
    private ProfesseurRepository Repo;
    @Override
    public Professeur save(Professeur prof) {
        return Repo.save(prof);
    }

    @Override
    public Professeur getOne(long id) {
        return Repo.findById(id).get();
    }

    @Override
    public Professeur update(Professeur prof, long id,int charge_horaire,int charge_hor_affecte) {
        prof.setId(id);prof.setCharge_hor_disponible(charge_horaire);prof.setCharge_hor_affecte(charge_hor_affecte);
        return Repo.save(prof);
    }

    @Override
    public void delete(long id) {
        Repo.deleteById(id);
    }

    @Override
    public List<Professeur> getAll() {
        return Repo.findAll();
    }
    @Override
    public ArrayList<Professeur> findByDep(Departement dep) { return Repo.findByDep(dep);}

    @Override
    public void reinstaliser_charge_horaire_dispo() {
        Repo.reinstaliser_charge_horaire_dispo();
    }
    @Override
    public void reinstaliser_charge_horaire_affect() {
         Repo.reinstaliser_charge_horaire_affect();
    }



}
