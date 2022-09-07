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
@AllArgsConstructor @Getter @Setter
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


    @OneToMany( targetEntity=Semester.class, mappedBy="filiere" ,fetch = FetchType.EAGER)
    private Set<Semester> semester;


    @OneToMany( targetEntity=Etudiant.class, mappedBy="etudiantCollectionFiliere" ,fetch = FetchType.EAGER)
    private Set<Etudiant> etudiantCollectionFiliere;


}