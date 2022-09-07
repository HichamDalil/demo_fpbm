package com.fpbm.pack.entities;

import lombok.*;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity


@NoArgsConstructor
@AllArgsConstructor   @Getter @Setter

public class Departement {




    @Autowired
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @OneToMany( targetEntity=Filiere.class, mappedBy="departement" ,fetch = FetchType.EAGER)
    private List<Filiere> filireHasdepartement = new ArrayList<>();

    @OneToMany(targetEntity=Module.class, mappedBy="dep",fetch = FetchType.EAGER)
    private Set<Module> departementHasModuleCollection;

    @OneToMany(targetEntity=Professeur.class, mappedBy="dep",fetch = FetchType.EAGER)
    private Set<Professeur> departementHasProfesseurCollection;
}