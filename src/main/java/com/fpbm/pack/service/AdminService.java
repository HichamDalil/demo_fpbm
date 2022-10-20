package com.fpbm.pack.service;

import com.fpbm.pack.entities.Admin;

import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface AdminService {

    public Admin save(Admin admin);
    public List<Admin> getAll();
    public Admin getOne(Long id) ;
    public Admin update(Admin admin, Long id,String name) ;
    public void delete(Long id) ;
}
