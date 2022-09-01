package com.fpbm.pack.serviceimpl;

import com.fpbm.pack.entities.Departement;
import com.fpbm.pack.repositories.DepartementRepository;
import com.fpbm.pack.service.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DepartementServiceImpl implements DepartementService {
    @Autowired
    private DepartementRepository Repo;
    @Override
    public Departement save(Departement departement) {
        return Repo.save(departement);
    }
    @Override
    public List<Departement> getAll() {
        return Repo.findAll();
    }
    @Override
    public Departement getOne(Long id) {
        return Repo.findById(id).get();
    }
    @Override
    public Departement update(Departement dep, Long id) { dep.setId(id);return Repo.save(dep);}
    @Override
    public void delete(Long id) {
        Repo.deleteById(id);
    }
}
