package com.fpbm.pack;

import com.fpbm.pack.emploi_du_temps.Emploi_tuple;
import com.fpbm.pack.entities.*;
import com.fpbm.pack.entities.Module;
import com.fpbm.pack.serviceimpl.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@ComponentScan("com.fpbm.pack")
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
    //private static String[] amphie= {"A","B","C","D"};
    private static String[] periode= {"1","2","3","4"};
    private static String[] jour= {"lundi","mardi","mercredi","jeudi","vendredi","samedi"};
    private static String[] Tab_module= {"M1","M2","M3","M4","M5","M6","M7"};
    protected static String[][][] Tab_prof_jour_periode=new String[100][6][4] ;

    protected static String[][][] Tab_salle_jour_periode =new String[80][6][4] ;
    //protected static String[][][][][][][][] Emp=new String[4][1][4][7][7][6][4][100] ;
    private static int A,J,P,M,M_tab, Prof_index,nb_AJP=40,duree_seance=2,initial_charge_horaire=12;
    private static int[]Tab_Prof_charge_hor_affecte=new int[100];
    private static int[] Tab_Prof_charge_hor_disponible =new int[100];

    Random rand = new Random();
    Module module_selected=new Module();
    ArrayList<Emploi_tuple> list_emp_tuples =new ArrayList<Emploi_tuple>();
    //ArrayList<Salle> list_salle=new ArrayList<Salle>();
    //Emploidutemps empdt=new Emploidutemps();
    ArrayList<String> list_semester_executer=new ArrayList<String>();

    @Bean
    CommandLineRunner commandLineRunner(SalleServiceImpl salleService, DepartementServiceImpl depser, FiliereServiceImpl filiereService
    , SemesterServiceImpl semesterService,SectionServiceImpl sectionService, ModuleServiceImpl moduleService, ProfesseurServiceImpl professeurService){
        return args -> {
            System.gc();
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
                        // ce tableau n'est pas static puisque chaque semester a des sections ****************
                        String[][][] Tab_section_jour_per =new String[4][6][4] ;
                        for(Section section: listSection)
                        {
                            // pour verifier que toutes les semesters sont telechargés
                            list_semester_executer.add(s.getName_semester()+" "+section.getSection_name());
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
                                J=rand.nextInt(jour.length);
                                P=rand.nextInt(periode.length);
                                System.out.println("A=rand.nextInt(amphie.length)="+A+"  J=rand.nextInt(jour.length)="+J+"  P=rand.nextInt(periode.length)="+P);
                                //--------------------------------------
                                while (Tab_salle_jour_periode[A][J][P]=="occupe" && nb_AJP !=0
                                        || Tab_section_jour_per[((int) section.getSection_id_in_semester())][J][P]=="occupe"
                                        ||Tab_prof_jour_periode[Prof_index][J][P]=="occupe")
                                {
                                    A=rand.nextInt(listSalle.size());id_salle_in_listSalle=A;
                                    A=(int)listSalle.get(A).getId();
                                    J=rand.nextInt(jour.length);P=rand.nextInt(periode.length);
                                    System.out.println("dans la boucle while (Tab_amphie_jour_periode || Tab_section_jour_per ||Tab_prof_jour_periode ==\"occupe\" A="+A+" P="+P+" J="+J);
                                }
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
                        }
                    }
                    else {
                    //*** sinon : semester a une seule section ******************************************************
                        // pour verifier que toutes les semesters sont telechargés
                        list_semester_executer.add(s.getName_semester());
                        //-------------------------------------------------------*/
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
                    //ArrayList<Salle> listSalle=  salleService.getAll();
                    int id_salle_in_listSalle;
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
                        J=rand.nextInt(jour.length);P=rand.nextInt(periode.length);
                        System.out.println("A=rand.nextInt(amphie.length)="+A+"  J=rand.nextInt(jour.length)="+J+"  P=rand.nextInt(periode.length)="+P);
                        //--------------------------------------
                        while (Tab_salle_jour_periode[A][J][P]=="occupe" && nb_AJP !=0
                                || Tab_semester_jour_per[((int) s.getSemester_id_in_filiere())][J][P]=="occupe"
                        ||Tab_prof_jour_periode[Prof_index][J][P]=="occupe")
                        {
                            A=rand.nextInt(listSalle.size());id_salle_in_listSalle=A;
                            A=(int)listSalle.get(A).getId();
                            J=rand.nextInt(jour.length);P=rand.nextInt(periode.length);
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
                    }
                }
                //-------------------------------------------------------
                // pour verifier que toutes les semesters sont telechargés
                for(Semester s: listSemester)
                {System.out.println(s.getName_semester());}
                //-------------------------------------------------------*/

            }//la fin de remplissage de la liste des emploi_line

        //******affichage des emploi du temps

            System.out.println("list_emp_tuples ************************************************************************");
            System.out.println();
            for (Emploi_tuple e: list_emp_tuples)
            {
                System.out.println(e.toString()+"**");
            }
            System.out.println("list_semester_executer ************************************************************************");
            for (String e: list_semester_executer)
            {
                System.out.println(e.toString()+"----");
            }
            /*
            System.out.println("**********************en utilisant la class emploidutemps *********************************");
            for (Emploi_line e:empdt.all_emp_line())
            {
                System.out.println(e.toString()+"**emploi du temps implement****");
            }*/

        };
    }




}
