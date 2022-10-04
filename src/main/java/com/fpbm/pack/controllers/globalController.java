package com.fpbm.pack.controllers;
import com.fpbm.pack.emploi_du_temps.Emploi_tuple;
import com.fpbm.pack.emploi_du_temps.Emploi_tuple_org;
import com.fpbm.pack.emploi_du_temps.Groupe_Emploi_tuple_org;
import com.fpbm.pack.entities.*;


import com.fpbm.pack.entities.Module;
import com.fpbm.pack.serviceimpl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

//@RestController
//@RequestMapping("/Salle")
@Controller
public class globalController {
    @Autowired
    private SalleServiceImpl salleService;
    @Autowired
    private DepartementServiceImpl dep_serv;

    private DepartementServiceImpl depser;
    @Autowired
    private FiliereServiceImpl filiereService;
    @Autowired
    private SemesterServiceImpl semesterService;
    @Autowired
    private SectionServiceImpl sectionService;
    @Autowired
    private ModuleServiceImpl moduleService;
    @Autowired
    private ProfesseurServiceImpl professeurService;
    @Autowired
    private ProfesseurHasModuleServiceImpl professeurHasModuleService;

    private ArrayList<ArrayList<Emploi_tuple>> groupes_emp_tuples =new ArrayList<ArrayList<Emploi_tuple>>();
    private String[] periode= {"1","2","3","4"};
    private String[] jour= {"lundi","mardi","mercredi","jeudi","vendredi","samedi"};
    private ArrayList<Groupe_Emploi_tuple_org> list_Groupe_Emploi_tuples_org =new ArrayList<Groupe_Emploi_tuple_org>();
    private int[] Tab_Prof_charge_hor_disponible =new int[100];


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
   @GetMapping("/new_emploi")
   public ModelAndView viewemploiPage() {
       ModelAndView mav = new ModelAndView("new_emploi");

       list_Groupe_Emploi_tuples_org.clear();

        String[] Tab_module= {"M1","M2","M3","M4","M5","M6","M7"};
        String[][][] Tab_prof_jour_periode=new String[100][6][4] ;

        String[][][] Tab_salle_jour_periode =new String[80][6][4] ;
        int A,J,P,M=0,M_tab, Prof_index,nb_AJP=40,duree_seance=2,NSCJ=2,initial_charge_horaire=12;
        int[]Tab_Prof_charge_hor_affecte=new int[100];


       Random rand = new Random();
       Module module_selected=new Module();


       ArrayList<String[][]> groupes_mat_jour_periode =new ArrayList<String[][]>();

       List<Salle> listsalle = salleService.getAll();
       //System.out.print("Get /emploi ");
       //System.gc();
       System.out.println("******************* RunningCommandLineRunner ***************");
       //**************************************************************************************
       ArrayList<Professeur> all_prof=(ArrayList<Professeur>) professeurService.getAll();

       for (Professeur p:all_prof)
       {
           if((Object)p.getCharge_hor_disponible()!=null)
           {Tab_Prof_charge_hor_disponible[(int) p.getId()]=p.getCharge_hor_disponible();}
           else Tab_Prof_charge_hor_disponible[(int) p.getId()]=0;
       }

       //**************************************************************************************
       ArrayList<Filiere> listfiliere=filiereService.getAll();

       for (Filiere f: listfiliere)
       {

           ArrayList<Semester> listSemester=new ArrayList<Semester>();
           //if(listSemester.isEmpty())
           listSemester=semesterService.getbyfiliere(f);

           // ce tableau n'est pas static puisque chaque filiere a des semesters********
           String[][][] Tab_semester_jour_per =new String[6][6][4] ;
                /*/-------------------------------------------------------
                // pour verifier que toutes les semesters sont telechargés
                for(Semester s: listSemester)
                {System.out.println(s.getName_semester());}
                //-------------------------------------------------------*/
           for(Semester s: listSemester)
           {

               //*** si semester a des sections alors: ********************************************************
               ArrayList<Section> listSection=new ArrayList<Section>();
               listSection=sectionService.findbySemester(s);
               if (!listSection.isEmpty())
               {

                   // ici on va telecharger les amphie puisque il y a des sections **********************
                   ArrayList<Salle> listSalle=salleService.findByTypesalle("amphie");
                   //ArrayList<Salle> listSalle=  salleService.getAll();
                   int id_salle_in_listSalle;

                   for(Section section: listSection)
                   {
                       ArrayList<Emploi_tuple> list_emp_tuples =new ArrayList<Emploi_tuple>();
                       // ce tableau n'est pas static puisque chaque semester a des sections ****************
                       String[][][] Tab_section_jour_per =new String[4][6][4] ;

                       int [] Tab_NSCJ =new int[6];// tableau de Nombre de Seance par Jour
                       int Priorite_min=1,Priorite_max=19;//lundi(4) mar(4) Me(4) J(4) V(1) S(1)

                       //-------------------------------------------------------*/
                       System.out.println("********** choix des sections ***********");
                       ArrayList<Module> listModule=new ArrayList<>();
                       if(listModule.isEmpty()) listModule= moduleService.findBysemester(s);
                       int nb_module=listModule.size();
                       while (!listModule.isEmpty())
                       {
                           System.out.println("dans la boucle while (!listModule.isEmpty()) depuis section");
                           //choix du module ********************
                           M_tab=rand.nextInt(nb_module);System.out.println("choix du module  M_tab=rand.nextInt(nb_module):M="+M);
                           while (Tab_module[M_tab]=="occupe")
                           {M_tab=rand.nextInt(nb_module);System.out.println("dans la boucle while (Tab_module[M_tab]==\"occupe\") M="+M);}
                           //-------------------------------------------------
                           M=rand.nextInt(listModule.size());
                           module_selected=listModule.get(M);
                           //***choix du professeur******************************************************
                           List <Professeur> listprof=professeurService.findByDep(module_selected.getDep()) ;System.out.println("listprof=findByDep(module_selected.getDep())");
                           Prof_index =rand.nextInt(listprof.size());System.out.println("Prof_index =rand.nextInt(listprof.size())  Prof_index="+Prof_index);
                           Professeur professeur=listprof.get(Prof_index);
                           //verifier si le professeur est disponible--------------------------------------------
                           while(Tab_Prof_charge_hor_disponible[(int)professeur.getId()]==0)
                           {
                               Prof_index =rand.nextInt(listprof.size());System.out.println("verifier si le professeur est disponible depuis liste sections Prof_index= "+Prof_index);
                               professeur=listprof.get(Prof_index);
                           }
                           //******************************************************************************
                           A=rand.nextInt(listSalle.size());id_salle_in_listSalle=A;
                           A=(int)listSalle.get(A).getId();
                           //--------- choix du jour J { -------------------------------------------------
                           J=rand.nextInt(Priorite_min,Priorite_max);
                           switch (J)
                           {
                               case 1:J=0;break;case 2:J=0;break;case 3:J=0;break;case 4:J=0;break;
                               case 5:J=1;break;case 6:J=1;break;case 7:J=1;break;case 8:J=1;break;
                               case 9:J=2;break;case 10:J=2;break;case 11:J=2;break;case 12:J=2;break;
                               case 13:J=3;break;case 14:J=3;break;case 15:J=3;break;case 16:J=3;break;
                               case 17:J=4;break;
                               case 18:J=5;break;
                               default:System.out.println("valeur n'existe pas :switch (J)...");

                           }
                           while (Tab_NSCJ[J]==NSCJ)
                           {
                               J=rand.nextInt(Priorite_min,Priorite_max);
                               switch (J)
                               {
                                   case 1:J=0;break;case 2:J=0;break;case 3:J=0;break;case 4:J=0;break;
                                   case 5:J=1;break;case 6:J=1;break;case 7:J=1;break;case 8:J=1;break;
                                   case 9:J=2;break;case 10:J=2;break;case 11:J=2;break;case 12:J=2;break;
                                   case 13:J=3;break;case 14:J=3;break;case 15:J=3;break;case 16:J=3;break;
                                   case 17:J=4;break;
                                   case 18:J=5;break;
                                   default:System.out.println("valeur n'existe pas :switch (J)...");

                               }System.out.println("dans la boucle : while (Tab_NSCJ[J]>=NSCJ) dans for(Section section: listSection)");
                           }
                           //----------------- choix du jour J  }-------------------------------------
                           P=rand.nextInt(periode.length);
                           System.out.println("A=rand.nextInt(amphie.length)="+A+"  J=rand.nextInt(jour.length)="+J+"  P=rand.nextInt(periode.length)="+P);
                           //--------------------------------------
                           while (Tab_salle_jour_periode[A][J][P]=="occupe" && nb_AJP !=0
                                   || Tab_section_jour_per[((int) section.getSection_id_in_semester())][J][P]=="occupe"
                                   ||Tab_prof_jour_periode[Prof_index][J][P]=="occupe")
                           {
                               A=rand.nextInt(listSalle.size());id_salle_in_listSalle=A;
                               A=(int)listSalle.get(A).getId();
                               P=rand.nextInt(periode.length);
                               //--------- choix du jour J { -------------------------------------------------
                               J=rand.nextInt(Priorite_min,Priorite_max);
                               switch (J)
                               {
                                   case 1:J=0;break;case 2:J=0;break;case 3:J=0;break;case 4:J=0;break;
                                   case 5:J=1;break;case 6:J=1;break;case 7:J=1;break;case 8:J=1;break;
                                   case 9:J=2;break;case 10:J=2;break;case 11:J=2;break;case 12:J=2;break;
                                   case 13:J=3;break;case 14:J=3;break;case 15:J=3;break;case 16:J=3;break;
                                   case 17:J=4;break;
                                   case 18:J=5;break;
                                   default:System.out.println("valeur n'existe pas :switch (J)...");

                               }
                               while (Tab_NSCJ[J]>=NSCJ)
                               {
                                   J=rand.nextInt(Priorite_min,Priorite_max);
                                   switch (J)
                                   {
                                       case 1:J=0;break;case 2:J=0;break;case 3:J=0;break;case 4:J=0;break;
                                       case 5:J=1;break;case 6:J=1;break;case 7:J=1;break;case 8:J=1;break;
                                       case 9:J=2;break;case 10:J=2;break;case 11:J=2;break;case 12:J=2;break;
                                       case 13:J=3;break;case 14:J=3;break;case 15:J=3;break;case 16:J=3;break;
                                       case 17:J=4;break;
                                       case 18:J=5;break;
                                       default:System.out.println("valeur n'existe pas :switch (J)...");

                                   }System.out.println("dans la boucle : while (Tab_NSCJ[J]>=NSCJ) dans for(Section section: listSection)");
                               }
                               //----------------- choix du jour J  }----------------------------------------------

                               System.out.println("dans la boucle while (Tab_amphie_jour_periode || Tab_section_jour_per ||Tab_prof_jour_periode ==\"occupe\" A="+A+" P="+P+" J="+J);
                           }
                           //--------------------------------------
                           Tab_NSCJ[J]++;
                           //--------------------------------------
                           Tab_Prof_charge_hor_disponible[(int)professeur.getId()]-=duree_seance;
                           //--------------------------------------
                           Tab_salle_jour_periode[A][J][P]="occupe";
                           Tab_section_jour_per[((int) section.getSection_id_in_semester())][J][P]="occupe";
                           Tab_prof_jour_periode[Prof_index][J][P]="occupe";

                           //***********************************************
                           Tab_module[M_tab]="occupe";
                           //***insertion dans emploi_tuples****************
                           Emploi_tuple emp=new Emploi_tuple();
                           emp.setFiliere(f);
                           emp.setSemestre(s);
                           emp.setSection(section);
                           emp.setModule(module_selected);
                           emp.setProf(professeur);
                           emp.setJour(jour[J]);
                           emp.setSalle(listSalle.get(id_salle_in_listSalle));
                           emp.setPeriode(periode[P]);
                           list_emp_tuples.add(emp);System.out.println("ajouter emp_line depuis section");
                           listModule.remove(M);System.out.println("supprimer module depuis section");//.....avant supprimer le module
                           System.out.println(emp);
                           nb_AJP--;System.out.println("emp n:"+(40-nb_AJP));
                           //**********************


                       }
                       Tab_module= new String[]{"M1", "M2", "M3", "M4", "M5", "M6", "M7"};
                       //---sauvegard des emp_tuples dans des groups ---------------------------------------------
                       groupes_emp_tuples.add(list_emp_tuples);
                       //-----------------------------------------------------------------------------------------
                   }


               }

               else {

                   ArrayList<Emploi_tuple> list_emp_tuples =new ArrayList<Emploi_tuple>();

                   ArrayList<Module> listModule=new ArrayList<>();
                   if(listModule.isEmpty()) listModule= moduleService.findBysemester(s);
                   int nb_module=listModule.size();
                   //****choix des salles **********************************************************************************
                   int nb_etudiant= (int) s.getNb_etudiant();
                   ArrayList<Salle> listSalle=(ArrayList<Salle>)salleService.findBycapaciteEtudiantBetween(nb_etudiant,nb_etudiant+10);
                   int nb_test=1;
                   while (listSalle.isEmpty() &&nb_test<8)
                   {
                       nb_test++;listSalle=(ArrayList<Salle>)salleService.findBycapaciteEtudiantBetween(nb_etudiant,nb_etudiant+10*nb_test);
                   }
                   //***-----------------**----------------**-------------**-----------------------------------------------------------
                   int id_salle_in_listSalle;
                   int [] Tab_NSCJ =new int[6];// tableau de Nombre de Seance par Jour
                   int Priorite_min=1,Priorite_max=19;//lundi(4) mar(4) Me(4) J(4) V(1) S(1)
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
                       //choix du professeur****************************************************
                       List <Professeur> listprof=professeurService.findByDep(module_selected.getDep()) ;System.out.println("listprof=findByDep(module_selected.getDep())");
                       Prof_index =rand.nextInt(listprof.size());System.out.println("Prof_index =rand.nextInt(listprof.size())  Prof_index="+Prof_index);
                       Professeur professeur=listprof.get(Prof_index);
                       //verifier si le professeur est disponible--------------------------------------------
                       while(Tab_Prof_charge_hor_disponible[(int)professeur.getId()]==0)
                       {
                           Prof_index =rand.nextInt(listprof.size());System.out.println("verifier si le professeur est disponible depuis liste semester= "+s.getName_semester()+" Prof_index= "+professeur.getId());
                           professeur=listprof.get(Prof_index);
                       }
                       //***************************************************************
                       A=rand.nextInt(listSalle.size());id_salle_in_listSalle=A;
                       A=(int)listSalle.get(A).getId();
                       P=rand.nextInt(periode.length);
                       //--------- choix du jour J { -------------------------------------------------------------
                       J=rand.nextInt(Priorite_min,Priorite_max);
                       switch (J)
                       {
                           case 1:J=0;break;case 2:J=0;break;case 3:J=0;break;case 4:J=0;break;
                           case 5:J=1;break;case 6:J=1;break;case 7:J=1;break;case 8:J=1;break;
                           case 9:J=2;break;case 10:J=2;break;case 11:J=2;break;case 12:J=2;break;
                           case 13:J=3;break;case 14:J=3;break;case 15:J=3;break;case 16:J=3;break;
                           case 17:J=4;break;
                           case 18:J=5;break;
                           default:System.out.println("valeur n'existe pas :switch (J)...");

                       }
                       while (Tab_NSCJ[J]==NSCJ)
                       {
                           J=rand.nextInt(Priorite_min,Priorite_max);
                           switch (J)
                           {
                               case 1:J=0;break;case 2:J=0;break;case 3:J=0;break;case 4:J=0;break;
                               case 5:J=1;break;case 6:J=1;break;case 7:J=1;break;case 8:J=1;break;
                               case 9:J=2;break;case 10:J=2;break;case 11:J=2;break;case 12:J=2;break;
                               case 13:J=3;break;case 14:J=3;break;case 15:J=3;break;case 16:J=3;break;
                               case 17:J=4;break;
                               case 18:J=5;break;
                               default:System.out.println("valeur n'existe pas :switch (J)...");

                           }System.out.println("dans la boucle : while (Tab_NSCJ[J]>=NSCJ) dans for(Section section: listSection)");
                       }
                       //----------------- choix du jour J  }-------------------------------------
                       System.out.println("A=rand.nextInt(amphie.length)="+A+"  J=rand.nextInt(jour.length)="+J+"  P=rand.nextInt(periode.length)="+P);
                       //--------------------------------------
                       while (Tab_salle_jour_periode[A][J][P]=="occupe" && nb_AJP !=0
                               || Tab_semester_jour_per[((int) s.getSemester_id_in_filiere())][J][P]=="occupe"
                               ||Tab_prof_jour_periode[Prof_index][J][P]=="occupe")
                       {
                           A=rand.nextInt(listSalle.size());id_salle_in_listSalle=A;
                           A=(int)listSalle.get(A).getId();
                           P=rand.nextInt(periode.length);
                           //--------- choix du jour J { -------------------------------------------------
                           J=rand.nextInt(Priorite_min,Priorite_max);
                           switch (J)
                           {
                               case 1:J=0;break;case 2:J=0;break;case 3:J=0;break;case 4:J=0;break;
                               case 5:J=1;break;case 6:J=1;break;case 7:J=1;break;case 8:J=1;break;
                               case 9:J=2;break;case 10:J=2;break;case 11:J=2;break;case 12:J=2;break;
                               case 13:J=3;break;case 14:J=3;break;case 15:J=3;break;case 16:J=3;break;
                               case 17:J=4;break;
                               case 18:J=5;break;
                               default:System.out.println("valeur n'existe pas :switch (J)...");

                           }
                           while (Tab_NSCJ[J]==NSCJ)
                           {
                               J=rand.nextInt(Priorite_min,Priorite_max);
                               switch (J)
                               {
                                   case 1:J=0;break;case 2:J=0;break;case 3:J=0;break;case 4:J=0;break;
                                   case 5:J=1;break;case 6:J=1;break;case 7:J=1;break;case 8:J=1;break;
                                   case 9:J=2;break;case 10:J=2;break;case 11:J=2;break;case 12:J=2;break;
                                   case 13:J=3;break;case 14:J=3;break;case 15:J=3;break;case 16:J=3;break;
                                   case 17:J=4;break;
                                   case 18:J=5;break;
                                   default:System.out.println("valeur n'existe pas :switch (J)...");

                               }System.out.println("dans la boucle : while (Tab_NSCJ[J]>=NSCJ) dans for(Section section: listSection)");
                           }
                           //----------------- choix du jour J  }-------------------------------------
                           Prof_index =rand.nextInt(listprof.size());System.out.println("Prof_index =rand.nextInt(listprof.size())  Prof_index="+Prof_index);
                           professeur=listprof.get(Prof_index);
                           System.out.println("dans la boucle while (Tab_amphie_jour_periode || Tab_semester_jour_per ||Tab_prof_jour_periode ==\"occupe\" A="+A+" P="+P+" J="+J);
                       }
                       //--------------------------------------
                       Tab_Prof_charge_hor_disponible[(int)professeur.getId()]-=duree_seance;
                       //--------------------------------------
                       Tab_salle_jour_periode[A][J][P]="occupe";
                       Tab_semester_jour_per[((int) s.getSemester_id_in_filiere())][J][P]="occupe";
                       Tab_prof_jour_periode[Prof_index][J][P]="occupe";
                       //**********************
                       Tab_module[M_tab]="occupe";
                       //***insertion dans emploi_tuples****************
                       Emploi_tuple emp=new Emploi_tuple();
                       emp.setFiliere(f);
                       emp.setSemestre(s);
                       emp.setModule(module_selected);
                       emp.setProf(professeur);
                       emp.setJour(jour[J]);
                       emp.setSalle(listSalle.get(id_salle_in_listSalle));
                       emp.setPeriode(periode[P]);
                       list_emp_tuples.add(emp);System.out.println("ajouter emp_line");
                       listModule.remove(M);System.out.println("supprimer module");//.....avant supprimer le module
                       System.out.println(emp);
                       nb_AJP--;System.out.println("emp n:"+(40-nb_AJP));
                       //**********************


                   }
                   Tab_module= new String[]{"M1", "M2", "M3", "M4", "M5", "M6", "M7"};
                   //---sauvegard des emp_tuples dans des groups ---------------------------------------------
                   groupes_emp_tuples.add(list_emp_tuples);
                   //-----------------------------------------------------------------------------------------

               }

           }
           //-------------------------------------------------------
           /* pour verifier que toutes les semesters sont telechargés
           for(Semester s: listSemester)
           {System.out.println(s.getName_semester());}
           -------------------------------------------------------*/

       }//la fin de remplissage de la liste des emploi_line

       //******affichage des emploi du temps

       System.out.println("list_emp_tuples ************************************************************************");
       System.out.println();

       for (ArrayList< Emploi_tuple> g: groupes_emp_tuples)
       {
           for (Emploi_tuple e: g) {System.out.println(e.toString()+"****");}
       }
       System.out.println("fin d'affichage' du groupes_emp_tuples");

       //-------conversion vers des matrices------------------------------ ------------
       for (ArrayList< Emploi_tuple> g: groupes_emp_tuples)
       {
           if(!g.isEmpty())
           {
               String[][] mat_jour_periode=new String[7][5];
               for (Emploi_tuple e: g)
               {
                   //System.out.println(Arrays.asList(jour).indexOf(e.getJour()));
                   mat_jour_periode[Arrays.asList(jour).indexOf(e.getJour())][Arrays.asList(periode).indexOf(e.getPeriode())+1]
                           =e.getModule().getModule_name()+" Pr:"+e.getProf().getFullName()+" locale:"+e.getSalle().getName();
                   mat_jour_periode[Arrays.asList(jour).indexOf(e.getJour())][0]=e.getJour();
                   mat_jour_periode[6][0]=e.getFiliere().getName()+"  "+e.getSemestre().getName_semester()+"  ";
                   if(e.getSection()!=null){mat_jour_periode[6][0]+=e.getSection().getSection_name();}
               }
               //pour ajouter les jours manquant : {--------------------------------
               for (int i = 0; i < jour.length; i++)
               {
                   if(mat_jour_periode[i][0]==null) {mat_jour_periode[i][0]=jour[i];}
               }
               //pour ajouter les jours manquant : }--------------------------------

               groupes_mat_jour_periode.add(mat_jour_periode);
           }

       }
       //-----fin du conversion vers des matrices--------------------------------------

       //------- tri des groupes_emp_tuples à l'aide des matrices------------------------------
       for (String[][] m:groupes_mat_jour_periode)
       {
           Groupe_Emploi_tuple_org groupe_EMPO=new Groupe_Emploi_tuple_org();
           groupe_EMPO.setList_eto(new ArrayList<>());
           for (int i=0;i<m.length-1;i++)

           {
               Emploi_tuple_org emploiTuplesOrg=new Emploi_tuple_org();
               emploiTuplesOrg.setJour(m[i][0]);
               emploiTuplesOrg.setP1(m[i][1]);
               emploiTuplesOrg.setP2(m[i][2]);
               emploiTuplesOrg.setP3(m[i][3]);
               emploiTuplesOrg.setP4(m[i][4]);

               groupe_EMPO.getList_eto().add(emploiTuplesOrg);

           }
           groupe_EMPO.setInformation(m[6][0]);
           list_Groupe_Emploi_tuples_org.add(groupe_EMPO);
       }
       //----fin tri des groupes_emp_tuples à l'aide des matrices--------------------------------
       //******affichage d'emploi -------------------------------------------------------------------------
      /* System.out.println("----- affichage d'emploi depuis la matrice ------");
       for (String[][] m:groupes_mat_jour_periode)
            {
                for (int i=1;i<m.length;i++)
                {
                    for (int j=1;j<m[i].length;j++)
                    {
                        System.out.print(m[i][j]+"    ");
                    }
                    System.out.println("");
                }
            }*/
       //---affichage des tuples organiser-------------------------------
       System.out.println("affichage des tuples organiser");
       for (Groupe_Emploi_tuple_org emp:list_Groupe_Emploi_tuples_org)
       {
           System.out.println(emp.getInformation());
           for (Emploi_tuple_org e:emp.getList_eto())
           {
               System.out.println(e.toString());
           }
           System.out.println("      ");
       }
       //---fin d'affichage des tuples organiser-------------------------------

       mav.clear();
       System.out.println(mav.isEmpty());
       mav.addObject("list_Groupe_eto", list_Groupe_Emploi_tuples_org);


       return mav;
   }

//********************************************************************************************/

    @GetMapping("/emploi_saved")
    public ModelAndView saveemploiPage(){
        ModelAndView mav = new ModelAndView("emploi_saved");
        mav.clear();
        mav.addObject("groupes_emp_tuples", groupes_emp_tuples);
        //----enregitrer l'emploi ------------------------
        for (ArrayList< Emploi_tuple> g: groupes_emp_tuples)
        {

            for (Emploi_tuple e: g)
            {
                ProfesseurHasModule professeurHasModule=new ProfesseurHasModule();
                professeurHasModule.setModule(e.getModule());
                professeurHasModule.setProfesseur(e.getProf());
                professeurHasModule.setSalle(e.getSalle());
                if (e.getSection() != null) {professeurHasModule.setSection(e.getSection());}
                Jour j=new Jour();int indice_jour=Arrays.asList(jour).indexOf(e.getJour());
                j.setId(indice_jour+1);j.setJour(jour[indice_jour]);
                professeurHasModule.setJour(j);
                Periode p=new Periode();
                p.setId(Arrays.asList(periode).indexOf(e.getPeriode())+1);p.setPeriode("p1");
                professeurHasModule.setPeriode(p);
                Annee annee=new Annee(); annee.setId(2);annee.setAnnee("2022");
                professeurHasModule.setAnnee(annee);
                Courstdtp courstdtp=new Courstdtp();courstdtp.setId(1);courstdtp.setName("Cours");
                professeurHasModule.setCoursTDTP(courstdtp);
                professeurHasModule.setSemester(e.getSemestre());
                professeurHasModuleService.save(professeurHasModule);

            }
        }
        //----enregitrer l'emploi ------------------------
        return mav;
    }
//********************************************************************************************/

    @GetMapping("/emploi")
    public ModelAndView getallemploiPage()
    {
        ArrayList<List<ProfesseurHasModule>>  groupe_global_ProHM=new ArrayList<List<ProfesseurHasModule>>();
        ArrayList<Groupe_Emploi_tuple_org>  groupe_global_emp_org=new ArrayList<Groupe_Emploi_tuple_org>();
        ArrayList<String[][]> groupes_mat_jour_periode =new ArrayList<String[][]>();

        List<Semester> list_global_semester=semesterService.getAll();
        for (Semester semester:list_global_semester)
        {
            List<ProfesseurHasModule> groupe_ProHM=professeurHasModuleService.findBySemester(semester);
            Set<Section> sectionSet=semester.getSections();
            if(!sectionSet.isEmpty())
            {

                for (Section section:sectionSet)
                {
                    List<ProfesseurHasModule> groupe_ProHM_mini=new ArrayList<ProfesseurHasModule>();
                    for (ProfesseurHasModule phm:groupe_ProHM)
                    {
                        if(phm.getSection().getId()==section.getId())
                        {
                            groupe_ProHM_mini.add(phm);
                        }
                    }
                    groupe_global_ProHM.add(groupe_ProHM_mini);
                }
            }
            //------- il n y a pas des sections --------------------
            else { groupe_global_ProHM.add(groupe_ProHM);}
        }

        //-------conversion vers des matrices------------------------------ ------------
        for (List< ProfesseurHasModule> g: groupe_global_ProHM)
        {
            if(!g.isEmpty())
            {
                String[][] mat_jour_periode2=new String[7][5];
                for (ProfesseurHasModule e: g)
                {
                    System.out.println(e.getModule().getModule_name()+" Pr: "+e.getProfesseur().getFullName()+" locale: "+e.getSalle().getName());

                    mat_jour_periode2[(int) e.getJour().getId()-1][(int)e.getPeriode().getId()]
                            =e.getModule().getModule_name()+" Pr: "+e.getProfesseur().getFullName()+" locale: "+e.getSalle().getName();
                    mat_jour_periode2[(int)e.getJour().getId()-1][0]= e.getJour().getJour();

                    mat_jour_periode2[6][0]=e.getSemester().getName_semester()+"  ";
                    if(e.getSection()!=null){mat_jour_periode2[6][0]+=e.getSection().getSection_name();}

                   /* for (int i=1;i<mat_jour_periode2.length;i++)
                    {
                        for (int j=0;j<mat_jour_periode2[i].length;j++)
                        {
                            if(i==e.getJour().getId()-1 && j==e.getPeriode().getId())
                            {
                                mat_jour_periode2[i][j]=e.getModule().getModule_name()+" Pr: "+e.getProfesseur().getFullName()+" locale: "+e.getSalle().getName();
                                System.out.print("depuis le sauvegarde......"+mat_jour_periode2[i][j]+"    ");
                            }

                        }
                        System.out.println("");
                    }*/
                }
                //pour ajouter les jours manquant : {--------------------------------
                for (int i = 0; i < jour.length; i++)
                {
                    if(mat_jour_periode2[i][0]==null) {mat_jour_periode2[i][0]=jour[i];}
                }
                //pour ajouter les jours manquant : }--------------------------------
                System.out.println("----mat_jour_periode---:");
                System.out.println(mat_jour_periode2);
                System.out.println("mat_jour_periode2[6][0]==");
                System.out.println(mat_jour_periode2[6][0]);
                System.out.println("----for (String[] mat:mat_jour_periode2)---:");
                for (String[] mat:mat_jour_periode2)
                {
                    for (String m:mat)
                    {
                        System.out.println(mat);
                    }

                }
                System.out.println("---------------:");
                groupes_mat_jour_periode.add(mat_jour_periode2);
            }

        }
        //-----fin du conversion vers des matrices--------------------------------------
        //******affichage d'emploi -------------------------------------------------------------------------
       System.out.println("----- affichage d'emploi depuis la matrice ------");
       for (String[][] m:groupes_mat_jour_periode)
            {
                for (int i=1;i<m.length;i++)
                {
                    for (int j=0;j<m[i].length;j++)
                    {
                        System.out.print(m[i][j]+"    ");
                    }
                    System.out.println("");
                }
            }
//------- tri des groupes_emp_tuples à l'aide des matrices------------------------------
        for (String[][] m:groupes_mat_jour_periode)
        {
            Groupe_Emploi_tuple_org groupe_EMPO=new Groupe_Emploi_tuple_org();
            groupe_EMPO.setList_eto(new ArrayList<>());
            for (int i=0;i<m.length-1;i++)

            {
                Emploi_tuple_org emploiTuplesOrg=new Emploi_tuple_org();
                emploiTuplesOrg.setJour(m[i][0]);
                emploiTuplesOrg.setP1(m[i][1]);
                emploiTuplesOrg.setP2(m[i][2]);
                emploiTuplesOrg.setP3(m[i][3]);
                emploiTuplesOrg.setP4(m[i][4]);

                groupe_EMPO.getList_eto().add(emploiTuplesOrg);

            }
            groupe_EMPO.setInformation(m[6][0]);
            groupe_global_emp_org.add(groupe_EMPO);
        }

        //----fin tri des groupes_emp_tuples à l'aide des matrices--------------------------------
        ModelAndView mav = new ModelAndView("emploi");
        mav.addObject("list_Groupe_eto", groupe_global_emp_org);

        return mav;
    }
}
