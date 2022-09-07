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
@AllArgsConstructor  @Getter
@Setter
public class LieuDeTravail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany(targetEntity=Professeur.class, mappedBy="LieuDeTravail",fetch = FetchType.EAGER)
    private Set<Professeur> professeurCollectionLieu ;

}