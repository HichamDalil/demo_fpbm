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
// ExamenHasProfesseurHasModuleHasEtudiant == ExamenHPrHMoHEt
public class ExamenHPrHMoHEt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(targetEntity= ProfesseurHMoHEt.class)
    private ProfesseurHMoHEt examens;
    @ManyToOne(targetEntity=Examen.class)
    private Examen examenHasProfesseur;
}
