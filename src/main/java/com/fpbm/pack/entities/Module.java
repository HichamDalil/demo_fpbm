package com.fpbm.pack.entities;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Groupe")
    private String Groupe;
    @OneToMany(targetEntity=ProfesseurHasModule.class, mappedBy="professeurHasModuleCollection")
    private Collection<ProfesseurHasModule> professeurHasModuleCollection;
    @ManyToOne(targetEntity=Semester.class)
    private Semester moduleCollectionSemester;
}