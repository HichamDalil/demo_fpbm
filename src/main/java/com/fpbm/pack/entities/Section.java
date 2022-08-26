package com.fpbm.pack.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany(targetEntity = ProfesseurHasModule.class, mappedBy = "professeurHasModuleCollectionSection")
    private Collection<ProfesseurHasModule> professeurHasModuleCollectionSection;
}