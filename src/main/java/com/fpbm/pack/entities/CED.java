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
    @OneToMany( targetEntity= PHDStudent.class, mappedBy="ced_idphdstudent",fetch = FetchType.EAGER )
    private Set<PHDStudent> ced_idphdstudent;
    @OneToMany( targetEntity=Labo.class, mappedBy="ced_idced" ,fetch = FetchType.EAGER)
    private Set<Labo> ced_idced;
    @OneToMany( targetEntity=Equipe.class, mappedBy="equipe_idequipe" ,fetch = FetchType.EAGER)
    private Set<Equipe> equipe_idequipe ;
}