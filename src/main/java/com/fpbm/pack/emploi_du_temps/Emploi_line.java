package com.fpbm.pack.emploi_du_temps;

import com.fpbm.pack.entities.*;
import com.fpbm.pack.entities.Module;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter @ToString
public class Emploi_line {

    private Filiere filiere;
    private Section section;
    private Semester semestre;
    private Module module;
    private Professeur prof;
    private String local;
    private String jour;
    private String periode;



    public Emploi_line() { }



}