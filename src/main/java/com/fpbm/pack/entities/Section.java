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
@Getter @Setter
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany(targetEntity = ProfesseurHasModule.class, mappedBy = "professeurHasModuleCollectionSection",fetch = FetchType.EAGER)
    private Set<ProfesseurHasModule> professeurHasModuleCollectionSection;
}