package com.fpbm.pack.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity

public class Semester_Section implements Serializable {

    //modification : creation d'une autre table
    @EmbeddedId
    @ManyToOne(targetEntity= Section.class)
    @JoinColumn(name = "section", referencedColumnName = "id")
    private Section section;
    @EmbeddedId
    @ManyToOne(targetEntity= Semester.class)
    @JoinColumn(name = "semester", referencedColumnName = "id")
    private Semester semester;
}
