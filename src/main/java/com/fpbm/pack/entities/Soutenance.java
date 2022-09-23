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
@AllArgsConstructor @Getter @Setter
public class Soutenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "sujet")
    private String sujet;
    @Column(name = "date")
    private String date;
    @Column(name = "soutenancecol")
    private String soutenanccol;
    @ManyToOne(targetEntity = Professeur.class)
    private Professeur soutenanceCollectionProfesseur;
    @OneToMany(targetEntity = Jury.class, mappedBy = "jury_idjury",fetch = FetchType.EAGER)
    private Set<Jury> jury_idjury;
    @ManyToOne(targetEntity = Salle.class)
    private Salle soutenance_idsoutenance;
    @ManyToOne(targetEntity = PHDStudent.class)
    private PHDStudent PHDstudent ;
}