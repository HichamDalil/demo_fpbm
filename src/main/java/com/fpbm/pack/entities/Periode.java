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
public class Periode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "periode")
    private String periode;

    @OneToMany(targetEntity= ProfesseurHasModule.class, mappedBy="periode",fetch = FetchType.EAGER)
    private Set<ProfesseurHasModule> professeurHasModule;
}
