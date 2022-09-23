package com.fpbm.pack.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Section implements Serializable {
    private static final long serialVersionUID = -7559895582123413329L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "section_name")
    private String section_name;
    @OneToMany(targetEntity = ProfesseurHasModule.class, mappedBy = "professeurHasModuleCollectionSection",fetch = FetchType.EAGER)
    private Set<ProfesseurHasModule> professeurHasModuleCollectionSection;

    //***********************************************************************
  /*  @OneToMany(targetEntity=Semester_Section.class,mappedBy="section",fetch = FetchType.EAGER)
    private Set<Semester_Section> Semester_Section;*/
}