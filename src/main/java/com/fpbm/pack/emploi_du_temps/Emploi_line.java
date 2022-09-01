package com.fpbm.pack.emploi_du_temps;

public class Emploi_line {

    private String semestre;
    private String filiere;
    private String local;
    private String module_name;
    private String jour;
    private String periode;



    public String getSemestre() {return semestre;}

    public String getFiliere() {return filiere;}

    public String getLocal() {return local;}

    public String getModule_name() {return module_name;}

    public String getJour() {return jour;}

    public String getPeriode() {return periode;}



    public void setSemestre(String semestre) {this.semestre = semestre;}

    public void setFiliere(String filiere) {this.filiere = filiere;}

    public void setLocal(String local) {this.local = local;}

    public void setModule_name(String module_name) {this.module_name = module_name;}

    public void setJour(String jour) {this.jour = jour;}

    public void setPeriode(String periode) {this.periode = periode;}

    public Emploi_line(String semestre, String filiere, String local, String module_name, String jour, String periode) {
        this.semestre = semestre;
        this.filiere = filiere;
        this.local = local;
        this.module_name = module_name;
        this.jour = jour;
        this.periode = periode;

    }

    public Emploi_line() { }

    @Override
    public String toString() {
        return "Emploi_line{" +
                ", semestre='" + semestre + '\'' +
                ", filiere='" + filiere + '\'' +
                ", amphie='" + local + '\'' +
                ", module_name='" + module_name + '\'' +
                ", jour='" + jour + '\'' +
                ", periode='" + periode + '\'' +
                '}';
    }
}