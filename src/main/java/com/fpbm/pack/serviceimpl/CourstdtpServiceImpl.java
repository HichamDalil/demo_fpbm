package com.fpbm.pack.serviceimpl;

import com.fpbm.pack.entities.Courstdtp;
import com.fpbm.pack.repositories.CourstdtpRepository;
import com.fpbm.pack.service.CourstdtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CourstdtpServiceImpl implements CourstdtpService {

    @Autowired
    private CourstdtpRepository Repo;

    @Override
    public Courstdtp save(Courstdtp courstdtp) { return Repo.save(courstdtp); }

    @Override
    public List<Courstdtp> getAll() { return Repo.findAll(); }

    @Override
    public Courstdtp getOne(Long id) { return Repo.findById(id).get(); }

    @Override
    public Courstdtp update(Courstdtp courstdtp, Long id,String name)
    {  Repo.findById(id).get().setName(name);return save(courstdtp); }

    @Override
    public void delete(Long id) { Repo.deleteById(id); }
}
