package com.fpbm.pack.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Admin  extends User{
    private String cin;
    private String nom;
    private String prenom;
    private Date dateDeNaissance;
    private String Address;
    private String telephone;
}
