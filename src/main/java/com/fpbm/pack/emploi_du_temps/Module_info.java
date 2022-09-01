package com.fpbm.pack.emploi_du_temps;

public class Module_info {
    private int id;
    private int id_fil;
    private String module_name;
    private String dep_name;
    private String semestre;

    public int getId() {return id;}

    public int getId_fil() { return id_fil;}

    public String getModule_name() {return module_name;}

    public String getDep_name() {return dep_name;}

    public String getSemestre() {return semestre;}

    public void setId(int id) {this.id = id;}

    public void setId_fil(int id_fil) {this.id_fil = id_fil;}

    public void setModule_name(String module_name) {this.module_name = module_name;}

    public void setDep_name(String dep_name) {this.dep_name = dep_name;}

    public void setSemestre(String semestre) {this.semestre = semestre;}

    public Module_info(int id,int id_fil,String module_name, String dep_name, String semestre) {
        this.id = id;
        this.id_fil = id_fil;
        this.module_name = module_name;
        this.dep_name = dep_name;
        this.semestre = semestre;
    }

    public Module_info() {}

    @Override
    public String toString() {
        return "Module_info{" +
                "id=" + id +
                ", id_fil=" + id_fil +
                "module_name='" + module_name + '\'' +
                ", dep_name='" + dep_name + '\'' +
                ", semestre='" + semestre + '\'' +
                '}';
    }
}
