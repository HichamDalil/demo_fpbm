package com.fpbm.pack.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@NoArgsConstructor
@AllArgsConstructor @Setter @Getter
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name_semester")
    private String name_semester;
    @OneToMany(targetEntity= Module.class, mappedBy="semester")
    private Collection<Module> moduleCollectionSemester;
    @ManyToOne(targetEntity=Filiere.class)
    private Filiere filiere;
}