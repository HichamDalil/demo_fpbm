package com.fpbm.pack.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor  @Getter
@Setter
public class Surveillant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(targetEntity=Examen.class)
    private Examen surveillantCollectionExamen;
    @ManyToOne(targetEntity=Professeur.class)
    private Professeur surveillantCollectionProfesseur;

}