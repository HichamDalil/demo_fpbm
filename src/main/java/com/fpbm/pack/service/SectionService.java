package com.fpbm.pack.service;

import com.fpbm.pack.entities.Section;
import com.fpbm.pack.entities.Semester;
import java.util.ArrayList;
import java.util.List;

public interface SectionService {

    public Section save(Section s);
    public List<Section> getAll();
    public Section getOne(Long id) ;
    public Section update(Section s, Long id) ;
    public void delete(Long id) ;

    //*************************************
    public ArrayList<Section> findbySemester(Semester semester) ;
}
