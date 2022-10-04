package com.fpbm.pack.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor @Setter @Getter
public class Semester{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "semester_id_in_filiere")
    private int semester_id_in_filiere;
    @Column(name = "name_semester")
    private String name_semester;
    //modification : on a ajouté une colone qui contient le nb des inscrits ;
    @Column(name = "nb_etudiant")
    private long nb_etudiant;
    @OneToMany(targetEntity= Module.class, mappedBy="semester",fetch = FetchType.EAGER)
    private Set<Module> moduleCollectionSemester;
    @ManyToOne(targetEntity=Filiere.class)
    private Filiere filiere;

    @OneToMany(targetEntity = Section.class, mappedBy = "semester",fetch = FetchType.EAGER)
    private Set<Section> sections;
    @OneToMany(targetEntity = ProfesseurHasModule.class, mappedBy = "semester",fetch = FetchType.EAGER)
    private Set<ProfesseurHasModule> professeurHasModuleSet;
    public void setNb_etudiant(long nb_etudiant) {
        this.nb_etudiant = nb_etudiant;
    }
}