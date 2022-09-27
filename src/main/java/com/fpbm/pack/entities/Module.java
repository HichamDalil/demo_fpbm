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
@AllArgsConstructor
@Setter  @Getter
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Module_name")
    private String Module_name;
    @Column(name = "groupe")
    private String groupe;
    //***********************************************************
    @Column(name = "has_td_tp")
    private String has_td_tp="td";
    @Column(name = "td_type")
    private String td_type="en_salle";
    @Column(name = "tp_type")
    private String tp_type;


    @OneToMany(targetEntity=ProfesseurHasModule.class, mappedBy="professeurHasModuleCollection",fetch = FetchType.EAGER)
    private Set<ProfesseurHasModule> professeurHasModuleCollection;
    @ManyToOne(targetEntity=Semester.class)
    private Semester semester;
    //modification : il y a une relation entre le module et département
    @ManyToOne(targetEntity=Departement.class)
    private Departement dep;
}