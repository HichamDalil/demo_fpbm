package com.fpbm.pack.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Section  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "section_name")
    private String section_name;
    @Column(name = "section_id_in_semester")
    private int section_id_in_semester;
    @OneToMany(targetEntity = ProfesseurHasModule.class, mappedBy = "professeurHasModuleCollectionSection",fetch = FetchType.EAGER)
    private Set<ProfesseurHasModule> professeurHasModuleCollectionSection;

    //***********************************************************************
    @ManyToOne(targetEntity=Semester.class)
    private Semester semester;
}