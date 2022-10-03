package com.fpbm.pack.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Jour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "jour")
    private String jour;

    @OneToMany(targetEntity= ProfesseurHasModule.class, mappedBy="jour",fetch = FetchType.EAGER)
    private Set<ProfesseurHasModule> professeurHasModule;
}
