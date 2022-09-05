package com.fpbm.pack.entities;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Collection;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Filiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    // *********************************
    @ManyToOne(targetEntity=Departement.class)
    private Departement departement;

    @ManyToOne( targetEntity=Type.class)
    private Type Type;

    @ManyToOne(targetEntity=Professeur.class)
    private Professeur filiereCollectionProfesseur;


    @OneToMany( targetEntity=Semester.class, mappedBy="filiere" )
    private Collection<Semester> semester;


    @OneToMany( targetEntity=Etudiant.class, mappedBy="etudiantCollectionFiliere" )
    private Collection<Etudiant> etudiantCollectionFiliere;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Departement getDepartement_iddepartement() {
        return departement;
    }

    public Type getFiliereCollectionType() {
        return Type;
    }

    public Professeur getFiliereCollectionProfesseur() {
        return filiereCollectionProfesseur;
    }

    public Collection<Semester> getFiliereCollectionSemester() {
        return semester;
    }

    public Collection<Etudiant> getEtudiantCollectionFiliere() {
        return etudiantCollectionFiliere;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartement_iddepartement(Departement departement_iddepartement) {
        this.departement = departement_iddepartement;
    }

    public void setFiliereCollectionType(Type filiereCollectionType) {
        this.Type = filiereCollectionType;
    }

    public void setFiliereCollectionProfesseur(Professeur filiereCollectionProfesseur) {
        this.filiereCollectionProfesseur = filiereCollectionProfesseur;
    }

    public void setFiliereCollectionSemester(Collection<Semester> filiereCollectionSemester) {
        this.semester = filiereCollectionSemester;
    }

    public void setEtudiantCollectionFiliere(Collection<Etudiant> etudiantCollectionFiliere) {
        this.etudiantCollectionFiliere = etudiantCollectionFiliere;
    }
}