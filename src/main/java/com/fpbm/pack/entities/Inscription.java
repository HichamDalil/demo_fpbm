package com.fpbm.pack.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor  @Getter
@Setter
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "dateInscription")
    private String dateInscription;

    @ManyToOne(targetEntity= PHDStudent.class)
    private PHDStudent student_idPHDstudent;
}
