package com.fpbm.pack.emploi_du_temps;

import com.fpbm.pack.entities.Filiere;
import com.fpbm.pack.entities.Module;
import com.fpbm.pack.serviceimpl.FiliereServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Emploidutemps {

    private Emploi_line line=new Emploi_line();
    private List<Module_info> list_Mod_fil=new ArrayList<Module_info>();
    private List<Filiere> list_fil=new ArrayList<Filiere>();
    private static String[] jour= {"lundi","mardi","mercredi","jeudi","vendredi","samedi"};
    private static int Module_reste,nb_AJP;
    private FiliereServiceImpl filiereService;

    public List<Emploi_line> all_emp_line(){
        List<Filiere> listFiliere=new ArrayList<Filiere>();
        listFiliere=filiereService.getAll();


        for (Filiere f: listFiliere)
        {
            ArrayList<Emploi_line> selected_line_emp=new ArrayList<Emploi_line>();
            System.out.println("************************************"+f+"************************************");
            System.out.println();
            selected_line_emp.clear();
            Module module=new Module();
            while (Module_reste!=0 && nb_AJP !=0){}

        }
        return null;
    }


}
