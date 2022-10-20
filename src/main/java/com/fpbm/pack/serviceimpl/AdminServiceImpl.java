package com.fpbm.pack.serviceimpl;

import com.fpbm.pack.entities.Admin;
import com.fpbm.pack.repositories.AdminRepository;
import com.fpbm.pack.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository Repo;

    @Override
    public Admin save(Admin admin) {
        return Repo.save(admin);
    }

    @Override
    public List<Admin> getAll() {
        return Repo.findAll();
    }

    @Override
    public Admin getOne(Long id) {
        return Repo.findById(id).get();
    }

    @Override
    public Admin update(Admin admin, Long id, String name) {
        Repo.findById(id).get().setNom(name);return save(admin);
    }

    @Override
    public void delete(Long id) {
        Repo.deleteById(id);
    }
}
