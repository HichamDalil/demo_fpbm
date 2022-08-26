package com.fpbm.pack.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity

@NoArgsConstructor
@AllArgsConstructor
// ProfesseurHasModuleHasEtudiant == ProfesseurHMoHEt
public class ProfesseurHMoHEt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(targetEntity=ProfesseurHasModule.class)
    private ProfesseurHasModule professeurHasModule;
    @ManyToOne(targetEntity=Etudiant.class)
    private Etudiant professeurHasModuleHasEtudiantCollectionEtudiant;
    @OneToMany(targetEntity= ExamenHPrHMoHEt.class, mappedBy="examens")
    private Collection<ExamenHPrHMoHEt> examens ;
}
