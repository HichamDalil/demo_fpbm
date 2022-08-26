package com.fpbm.pack.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@NoArgsConstructor
@AllArgsConstructor
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

    @OneToMany( targetEntity=Soutenance.class, mappedBy="soutenance_idsoutenance" )
    private Collection<Soutenance> soutenance_idsoutenance;
    @OneToMany( targetEntity=Examen.class, mappedBy="examen_module" )
    private Collection<Examen> examen_module;

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNombreSurveillant(long nombreSurveillant) {
        this.nombreSurveillant = nombreSurveillant;
    }

    public void setCapaciteEtudiant(long capaciteEtudiant) {
        this.capaciteEtudiant = capaciteEtudiant;
    }

    public String getName() {return name;  }

    public long getCapaciteEtudiant() {return capaciteEtudiant;   }

    public long getNombreSurveillant() {return nombreSurveillant;}

    public long getId() {return id;  }
}