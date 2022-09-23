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
@AllArgsConstructor @Getter
@Setter
public class CED {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany( targetEntity= PHDStudent.class, mappedBy="ced",fetch = FetchType.EAGER )
    private Set<PHDStudent> phdstudent;
    @OneToMany( targetEntity=Labo.class, mappedBy="ced" ,fetch = FetchType.EAGER)
    private Set<Labo> labo;
    @OneToMany( targetEntity=Equipe.class, mappedBy="ced" ,fetch = FetchType.EAGER)
    private Set<Equipe> equipe ;
}