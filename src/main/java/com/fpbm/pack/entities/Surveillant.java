package com.fpbm.pack.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Surveillant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(targetEntity=Examen.class)
    private Examen surveillantCollectionExamen;
    @ManyToOne(targetEntity=Professeur.class)
    private Professeur surveillantCollectionProfesseur;

}