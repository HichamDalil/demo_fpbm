package com.fpbm.pack.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ProfesseurHasModule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(targetEntity=Annee.class)
    private Annee Annee;
    @ManyToOne(targetEntity=Courstdtp.class)
    private Courstdtp CoursTDTP;
    @ManyToOne(targetEntity=Section.class)
    private Section Section;
    @OneToMany( targetEntity=Examen.class, mappedBy="examen_prof" ,fetch = FetchType.EAGER)
    private Set<Examen> examen_prof;
    @ManyToOne(targetEntity=Professeur.class)
    private Professeur professeur;
    @ManyToOne(targetEntity= Module.class)
    private Module Module;

    @ManyToOne(targetEntity= Salle.class)
    private Salle salle;

    @OneToMany(targetEntity= ProfesseurHMoHEt.class, mappedBy="professeurHasModule",fetch = FetchType.EAGER)
    private Set<ProfesseurHMoHEt> professeurHasModule;
}