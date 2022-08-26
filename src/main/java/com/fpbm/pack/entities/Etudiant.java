package com.fpbm.pack.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant extends Personne{
    @Column(name = "nbApogee")
    private String nbApogee;
    @ManyToOne(targetEntity=Filiere.class)
    private Filiere etudiantCollectionFiliere;
    @OneToMany(targetEntity= ProfesseurHMoHEt.class, mappedBy="professeurHasModuleHasEtudiantCollectionEtudiant")
    private Collection<ProfesseurHMoHEt> professeurHasModuleHasEtudiantCollectionEtudiant;
}