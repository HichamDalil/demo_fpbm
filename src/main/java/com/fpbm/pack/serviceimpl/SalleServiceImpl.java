package com.fpbm.pack.serviceimpl;

import com.fpbm.pack.entities.Salle;
import com.fpbm.pack.repositories.SalleRepository;
import com.fpbm.pack.service.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    public List<Salle> getAll() {
        return salleRepository.findAll();
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
}
