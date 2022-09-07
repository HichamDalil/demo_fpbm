package com.fpbm.pack.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Courstdtp {
    @Autowired
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @OneToMany( targetEntity=ProfesseurHasModule.class, mappedBy="professeurHasModuleCollectionCoursTDTP" ,fetch = FetchType.EAGER)
    private Set<ProfesseurHasModule> professeurHasModuleCollectionCoursTDTP;
}