package com.fpbm.pack.entities;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity

@NoArgsConstructor
@AllArgsConstructor
public class LieuDeTravail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany(targetEntity=Professeur.class, mappedBy="LieuDeTravail")
    private Collection<Professeur> professeurCollectionLieu ;

}