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
@AllArgsConstructor  @Getter
@Setter
public class Examen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "jour")
    private String jour;
    @Column(name = "heure")
    private String heure;
    @ManyToOne(targetEntity=Salle.class)
    private Salle examen_module;
    @ManyToOne(targetEntity=ProfesseurHasModule.class)
    private Salle examen_prof;
    @OneToMany(targetEntity= ExamenHPrHMoHEt.class, mappedBy="examenHasProfesseur",fetch = FetchType.EAGER)
    private Set<ExamenHPrHMoHEt> examenHasProfesseur;
    @OneToMany(targetEntity=Surveillant.class, mappedBy="surveillantCollectionExamen",fetch = FetchType.EAGER)
    private Set<Surveillant> surveillantCollectionExamen;
}