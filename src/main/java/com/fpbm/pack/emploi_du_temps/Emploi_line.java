package com.fpbm.pack.emploi_du_temps;

import com.fpbm.pack.entities.*;
import com.fpbm.pack.entities.Module;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter  @AllArgsConstructor
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

    @Override
    public String toString() {
        return "Emploi_line{" +
                "filiere=" + filiere.getName() +
                ", section=0" +
                ", semestre=" + semestre.getName_semester() +
                ", module=" + module.getModule_name() +
                ", prof=" + prof.getFullName() +
                ", local='" + local + '\'' +
                ", jour='" + jour + '\'' +
                ", periode='" + periode + '\'' +
                '}';
    }
}