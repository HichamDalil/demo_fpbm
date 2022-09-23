package com.fpbm.pack.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor @Setter @Getter
public class Semester implements Serializable {
    private static final long serialVersionUID = 6906240922716646312L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name_semester")
    private String name_semester;
    //modification : on a ajouté une colone qui contient le nb des inscrits ;
    @Column(name = "nb_etudiant")
    private long nb_etudiant;
    @OneToMany(targetEntity= Module.class, mappedBy="semester",fetch = FetchType.EAGER)
    private Set<Module> moduleCollectionSemester;
    @ManyToOne(targetEntity=Filiere.class)
    private Filiere filiere;
    public void setNb_etudiant(long nb_etudiant) {
        this.nb_etudiant = nb_etudiant;
    }
}