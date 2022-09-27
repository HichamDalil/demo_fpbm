package com.fpbm.pack.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor @Getter @Setter
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "capaciteEtudiant")
    private long capaciteEtudiant;
    @Column(name = "nombreSurveillant")
    private long nombreSurveillant;
    @Column(name = "type_salle")
    private String type_salle;


    @OneToMany( targetEntity=Soutenance.class, mappedBy="soutenance_idsoutenance" ,fetch = FetchType.EAGER)
    private Set<Soutenance> soutenance_idsoutenance;
    @OneToMany( targetEntity=Examen.class, mappedBy="examen_module" ,fetch = FetchType.EAGER)
    private Set<Examen> examen_module;


}