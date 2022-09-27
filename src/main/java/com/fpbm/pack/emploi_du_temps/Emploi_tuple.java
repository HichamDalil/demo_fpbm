package com.fpbm.pack.emploi_du_temps;

import com.fpbm.pack.entities.*;
import com.fpbm.pack.entities.Module;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter  @AllArgsConstructor
public class Emploi_tuple {

    private Filiere filiere;
    private Section section;
    private Semester semestre;
    private Module module;
    private Professeur prof;

    private Salle salle;
    private String jour;
    private String periode;

    public Emploi_tuple() { }

    @Override
    public String toString() {
        String section_name="";
        if(section!=null){section_name=section.getSection_name();}

        return "Emploi_line{" +
                "filiere=" + filiere.getName() +
                ", semestre=" + semestre.getName_semester() +" "+
                section_name+
                ", module=" + module.getModule_name() +
                ", prof=" + prof.getFullName() +
                ", local='" + salle.getName() + '\'' +
                ", jour='" + jour + '\'' +
                ", periode='" + periode + '\'' +
                '}';
    }
}