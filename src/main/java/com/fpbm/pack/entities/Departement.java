package com.fpbm.pack.entities;

import lombok.*;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity


@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Departement {
    public Departement(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {this.id = id; }

    @Autowired
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @OneToMany( targetEntity=Filiere.class, mappedBy="departement_iddepartement" )
    private List<Filiere> departement_iddepartement = new ArrayList<>();
}