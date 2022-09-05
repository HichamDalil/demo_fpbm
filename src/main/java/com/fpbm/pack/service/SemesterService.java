package com.fpbm.pack.service;

import com.fpbm.pack.entities.Filiere;
import com.fpbm.pack.entities.Semester;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface SemesterService {


    public  Semester save(Semester s);
    public List<Semester> getAll();
    public Semester getOne(Long id) ;
    public Semester update(Semester s, Long id) ;
    public void delete(Long id) ;
    //*************************************
    public ArrayList<Semester> getbyfiliere(Filiere f) ;

}
