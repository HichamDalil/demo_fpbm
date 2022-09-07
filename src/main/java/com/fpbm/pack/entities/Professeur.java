package com.fpbm.pack.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Professeur extends Personne{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "grade")
    private String grade;

    @OneToMany(targetEntity=Filiere.class, mappedBy="filiereCollectionProfesseur",fetch = FetchType.EAGER)
    private Set<Filiere> filiereCollectionProfesseur;
    @OneToMany(targetEntity=Jury.class, mappedBy="membrejury_idprofesseur",fetch = FetchType.EAGER)
    private Set<Jury> membrejury_idprofesseur;

    @ManyToOne(targetEntity = LieuDeTravail.class)
    private LieuDeTravail LieuDeTravail;
    @OneToMany(targetEntity=ProfesseurHasModule.class, mappedBy="prof_module",fetch = FetchType.EAGER)
    private Set<ProfesseurHasModule> prof_module;

    @ManyToOne(targetEntity = Extern.class)
    private Extern extern;
    @OneToMany(targetEntity = Surveillant.class, mappedBy = "surveillantCollectionProfesseur",fetch = FetchType.EAGER)
    private Set<Surveillant> surveillantCollectionProfesseur;
    @OneToMany(targetEntity = Soutenance.class, mappedBy = "soutenanceCollectionProfesseur",fetch = FetchType.EAGER)
    private Set<Soutenance> soutenanceCollectionProfesseur;
//modification : il y a une relation entre le prof et département
    @ManyToOne(targetEntity = Departement.class)
    private Departement dep;

}