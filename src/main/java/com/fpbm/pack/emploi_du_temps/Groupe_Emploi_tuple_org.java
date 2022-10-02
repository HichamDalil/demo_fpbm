package com.fpbm.pack.emploi_du_temps;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor  @NoArgsConstructor
public class Groupe_Emploi_tuple_org {
    private String information;
    private ArrayList<Emploi_tuple_org> list_eto;
}
