package com.fpbm.pack.controllers;
import com.fpbm.pack.emploi_du_temps.Emploi_line;
import com.fpbm.pack.entities.*;


import com.fpbm.pack.entities.Module;
import com.fpbm.pack.serviceimpl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//@RestController
//@RequestMapping("/Salle")
@Controller
public class SalleController {
    @Autowired
    private SalleServiceImpl salleService;
    @Autowired
    private DepartementServiceImpl dep_serv;


    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Salle> listsalle = salleService.getAll();
        model.addAttribute("listsalle", listsalle);
        System.out.print("Get / ");
        return "home";
    }

    @GetMapping("/homedep")
    public String viewHomePagedep(Model model) {
        List<Departement> departementList=dep_serv.getAll();
        model.addAttribute("departementList", departementList);
        System.out.print("Get /homedep ");
        return "homedepartement";
    }
    @GetMapping("/newdep")
    public String addDep(Model model) {
        model.addAttribute("dep", new Departement());
        return "newDepartement";
    }
    @RequestMapping(value = "/savedep", method = RequestMethod.POST)
    public String saveDep(@ModelAttribute("Dep") Departement d) {
        dep_serv.save(d);
        return "redirect:/homedepartement";
    }
    @RequestMapping("/deletedep/{id}")
    public String deletedep(@PathVariable(name = "id") long id) {
        dep_serv.delete(id);
        return "redirect:/homedepartement";
    }
    @RequestMapping("/editdep/{id}")
    public ModelAndView showEditPageDepartement(@PathVariable(name = "id") long id) {
        ModelAndView mav = new ModelAndView("newDep");
        Departement d = dep_serv.getOne(id);
        mav.addObject("dep", d);
        return mav;
    }
    @GetMapping("/homesalle")
    public String viewHomePageSalle(Model model) {
        List<Salle> listsalle = salleService.getAll();
        model.addAttribute("listsalle", listsalle);
        System.out.print("Get / ");
        return "homesalle";
    }
    //****************************************************************
    @GetMapping("/getsalle/{name}")
    public ModelAndView showSalle_findbyname(@PathVariable(name = "name")String name) {
        ModelAndView mav = new ModelAndView("sallebyname");
        Salle listsalle = salleService.getByname(name);
        mav.addObject("salle", listsalle);

        System.out.print("Get /getsalle/{name} ");
        return mav;
    }
    //****************************************************************
    @RequestMapping(value = "/saveSalle", method = RequestMethod.POST)
    public String saveSalle(@ModelAttribute("salle") Salle s) {
        salleService.save(s);
        return "redirect:/saveSalle";
    }
    @GetMapping("/newSalle")
    public String add(Model model) {
        model.addAttribute("salle", new Salle());
        return "newSalle";
    }
    @RequestMapping("/editSalle/{id}")
    public ModelAndView showEditPageSalle(@PathVariable(name = "id") long id) {
        ModelAndView mav = new ModelAndView("newSalle");
        Salle s = salleService.getOne(id);
        mav.addObject("salle", s);
        return mav;

    }


   @RequestMapping("/deleteSalle/{id}")
   public String deletesalle(@PathVariable(name = "id") long id) {
       salleService.delete(id);
       return "redirect:/deleteSalle";
   }
   //******************************************************************************************
   private static String[] amphie= {"A","B","C","D"};
    private static String[] periode= {"1","2","3","4"};
    private static String[] jour= {"lundi","mardi","mercredi","jeudi","vendredi","samedi"};
    private static String[] Tab_module= {"M1","M2","M3","M4","M5","M6","M7"};
    protected static String[][][] Tab_prof_jour_periode=new String[100][6][4] ;
    protected static String[][][] Tab_fil_jour_per=new String[4][6][4] ;
    protected static String[][][] Tab_amphie_jour_periode =new String[4][6][4] ;
    protected static String[][][][][][][][] Emp=new String[4][1][4][7][7][6][4][100] ;
    private static int A,J,P,M,M_tab,D, Prof_index,nb_AJP=30,Module_reste,count=0;
    Random rand = new Random();
    Module module_selected=new Module();
    ArrayList<Emploi_line> list_emp_line=new ArrayList<Emploi_line>();
    //SalleServiceImpl salleService;
    DepartementServiceImpl depser;
    @Autowired
    FiliereServiceImpl filiereService =new FiliereServiceImpl();
    @Autowired
    SemesterServiceImpl semesterService=new SemesterServiceImpl();
    @Autowired
    ModuleServiceImpl moduleService=new ModuleServiceImpl();
    @Autowired
    ProfesseurServiceImpl professeurService=new ProfesseurServiceImpl();
   public ArrayList<Emploi_line> all_emp_line(){
       List<Filiere> listFiliere=new ArrayList<Filiere>();
       listFiliere=filiereService.getAll();


       for (Filiere f: filiereService.getAll())
       {

           ArrayList<Semester> listSemester=new ArrayList<Semester>();
           if(listSemester.isEmpty()) listSemester=semesterService.getbyfiliere(f);
           for(Semester s: listSemester)
           {
               ArrayList<Module> listModule=new ArrayList<>();
               if(listModule.isEmpty()) listModule= moduleService.findBysemester(s);
               int nb_module=listModule.size();
               while (!listModule.isEmpty())
               {
                   System.out.println("dans la boucle while (!listModule.isEmpty())");
                   //choix du module ********************
                   M_tab=rand.nextInt(nb_module);System.out.println("choix du module  M_tab=rand.nextInt(nb_module):M="+M);
                   while (Tab_module[M_tab]=="occupe")
                   {M_tab=rand.nextInt(nb_module);System.out.println("dans la boucle while (Tab_module[M_tab]==\"occupe\") M="+M);}
                   //----------------
                   M=rand.nextInt(listModule.size());
                   module_selected=listModule.get(M);
                   //choix du professeur*****************
                   List <Professeur> listprof=professeurService.findByDep(module_selected.getDep()) ;System.out.println("listprof=findByDep(module_selected.getDep())");
                   Prof_index =rand.nextInt(listprof.size());System.out.println("Prof_index =rand.nextInt(listprof.size())  Prof_index="+Prof_index);
                   Professeur professeur=listprof.get(Prof_index);
                   //*********************************
                   A=rand.nextInt(amphie.length);J=rand.nextInt(jour.length);P=rand.nextInt(periode.length);
                   System.out.println("A=rand.nextInt(amphie.length)="+A+"  J=rand.nextInt(jour.length)="+J+"  P=rand.nextInt(periode.length)="+P);
                   //--------------------------------------
                   while (Tab_amphie_jour_periode[A][J][P]=="occupe" && nb_AJP !=0
                           || Tab_fil_jour_per[((int) f.getId())][J][P]=="occupe"
                           ||Tab_prof_jour_periode[Prof_index][J][P]=="occupe")
                   {
                       A=rand.nextInt(amphie.length);J=rand.nextInt(jour.length);
                       P=rand.nextInt(periode.length);
                       System.out.println("dans la boucle while (Tab_amphie_jour_periode || Tab_fil_jour_per ||Tab_prof_jour_periode ==\"occupe\"");
                   }
                   //----aprés sortir de la boucle---------

                   //--------------------------------------
                   Tab_amphie_jour_periode[A][J][P]="occupe";Tab_fil_jour_per[((int)f.getId())][J][P]="occupe";
                   Tab_prof_jour_periode[Prof_index][J][P]="occupe";
                   //**********************
                   Tab_module[M_tab]="occupe";
                   //***insertion dans emploi_line****************
                   Emploi_line emp=new Emploi_line();
                   emp.setFiliere(f);
                   emp.setSemestre(s);
                   emp.setModule(module_selected);
                   emp.setProf(professeur);
                   emp.setJour(jour[J]);
                   emp.setLocal(amphie[A]);
                   emp.setPeriode(periode[P]);
                   list_emp_line.add(emp);System.out.println("ajouter emp_line");
                   listModule.remove(M);System.out.println("supprimer module");//.....avant supprimer le module
                   System.out.println(emp);
                   nb_AJP--;System.out.println("emp n:"+(30-nb_AJP));
                   //**********************


               }
           }
       }//la fin de remplissage de la liste des emploi_line
       return list_emp_line;

   }
//********************************************************************************************


}
