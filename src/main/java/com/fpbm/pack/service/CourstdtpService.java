package com.fpbm.pack.service;

import com.fpbm.pack.entities.Courstdtp;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CourstdtpService {
    public Courstdtp save(Courstdtp courstdtp);
    public List<Courstdtp> getAll();
    public Courstdtp getOne(Long id) ;
    public Courstdtp update(Courstdtp courstdtp, Long id,String name) ;
    public void delete(Long id) ;
}
