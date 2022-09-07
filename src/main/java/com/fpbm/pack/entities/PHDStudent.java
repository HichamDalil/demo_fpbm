package com.fpbm.pack.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "phdstudent")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PHDStudent extends Etudiant{
    @OneToMany(targetEntity = Inscription.class, mappedBy = "student_idPHDstudent",fetch = FetchType.EAGER)
    private Set<Inscription> student_idPHDstudent;
    @OneToMany(targetEntity = Soutenance.class, mappedBy = "soutenance_idPHDstudent",fetch = FetchType.EAGER)
    private Set<Soutenance> soutenance_idPHDstudent;
    @ManyToOne(targetEntity = CED.class)
    private CED ced_idphdstudent;
}