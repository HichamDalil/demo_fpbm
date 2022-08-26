package com.fpbm.pack.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Jury {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(targetEntity=Professeur.class)
    private Professeur membrejury_idprofesseur;

    @ManyToOne( targetEntity=TypeJury.class)
    private TypeJury type_idtypejury;

    @ManyToOne( targetEntity=Soutenance.class)
    private Soutenance jury_idjury;

}