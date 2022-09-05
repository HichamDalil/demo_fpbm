package com.fpbm.pack.emploi_du_temps;

import com.fpbm.pack.entities.Filiere;
import com.fpbm.pack.entities.Module;
import com.fpbm.pack.entities.Semester;
import com.fpbm.pack.serviceimpl.FiliereServiceImpl;
import com.fpbm.pack.serviceimpl.ModuleServiceImpl;
import com.fpbm.pack.serviceimpl.SemesterServiceImpl;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class Emploidutemps {

    private Emploi_line line=new Emploi_line();
    private List<Module_info> list_Mod_fil=new ArrayList<Module_info>();
    private List<Filiere> list_fil=new ArrayList<Filiere>();
    private static String[] jour= {"lundi","mardi","mercredi","jeudi","vendredi","samedi"};
    private static int Module_reste,nb_AJP;
    private static FiliereServiceImpl filiereService;
    private static SemesterServiceImpl semesterService;
    private static ModuleServiceImpl moduleService;

    public  void all_emp_line(){
        List<Filiere> listFiliere=new ArrayList<Filiere>();
        listFiliere=filiereService.getAll();


        for (Filiere f: listFiliere)
        {
            ArrayList<Emploi_line> selected_line_emp=new ArrayList<Emploi_line>();
            System.out.println("************************************"+f+"************************************");
            System.out.println();
            selected_line_emp.clear();
            Module module=new Module();
            ArrayList<Semester> listSemester=semesterService.getbyfiliere(f);
            for(Semester s: listSemester)
            {
                ArrayList<Module> listModule=moduleService.findBysemester(s);
                for (Module m: listModule)
                {
                System.out.println("depuis la class emploidutemps"+m.getModule_name());
                }
            }

            //while (Module_reste!=0 && nb_AJP !=0){}

        }

    }

    public Emploidutemps()   { }
}
