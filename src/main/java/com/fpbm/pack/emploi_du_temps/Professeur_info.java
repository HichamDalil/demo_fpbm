package com.fpbm.pack.emploi_du_temps;

import java.util.ArrayList;

public class Professeur_info {
    private int id;
    private String prof_name;
    private String dep_name;
    private ArrayList <Module_info> list_module;
    private int charge_horaire;

    public int getId() {return id;}

    public String getProf_name() {return prof_name;}

    public String getDep_name() {return dep_name;}

    public ArrayList<Module_info> getList_module() {return list_module;}

    public int getCharge_horaire() {return charge_horaire;}

    public void setId(int id) {this.id = id;}

    public void setProf_name(String prof_name) {this.prof_name = prof_name;}

    public void setDep_name(String dep_name) {this.dep_name = dep_name;}

    public void setList_module(ArrayList<Module_info> list_module) {this.list_module = list_module;}

    public void setCharge_horaire(int charge_horaire) {this.charge_horaire = charge_horaire;}

    public Professeur_info(int id,String prof_name, String dep_name, ArrayList<Module_info> list_module, int charge_horaire) {
        this.id = id;
        this.prof_name = prof_name;
        this.dep_name = dep_name;
        this.list_module = list_module;
        this.charge_horaire = charge_horaire;
    }

    public Professeur_info() { }

}
