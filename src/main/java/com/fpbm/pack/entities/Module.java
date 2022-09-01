package com.fpbm.pack.entities;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Module_name")
    private String Module_name;
    @OneToMany(targetEntity=ProfesseurHasModule.class, mappedBy="professeurHasModuleCollection")
    private Collection<ProfesseurHasModule> professeurHasModuleCollection;
    @ManyToOne(targetEntity=Semester.class)
    private Semester moduleCollectionSemester;

}