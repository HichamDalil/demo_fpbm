package com.fpbm.pack.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.util.Date;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
@NoArgsConstructor
@AllArgsConstructor
public abstract class Personne extends User{

    private String cin;
    private String cne;
    private String nom;
    private String prenom;
    private Date dateDeNaissance;
    private String Address;
    private String telephone;
}