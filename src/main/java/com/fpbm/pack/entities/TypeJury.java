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
@AllArgsConstructor  @Getter
@Setter
public class TypeJury {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany( targetEntity=Jury.class, mappedBy="type_idtypejury" ,fetch = FetchType.EAGER)
    private Set<Jury> type_idtypejury;


}