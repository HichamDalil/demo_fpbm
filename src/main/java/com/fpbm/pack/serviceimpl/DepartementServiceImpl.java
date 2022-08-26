package com.fpbm.pack.serviceimpl;

import com.fpbm.pack.entities.Departement;
import com.fpbm.pack.repositories.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DepartementServiceImpl {
    @Autowired
    private DepartementRepository Repo;

    public Departement save(Departement departement) {
        return Repo.save(departement);
    }

    public List<Departement> getAll() {
        return Repo.findAll();
    }
}
