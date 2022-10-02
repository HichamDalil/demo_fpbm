package com.fpbm.pack.emploi_du_temps;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor  @NoArgsConstructor
public class Emploi_tuple_org {

    private String jour;
    private String p1;
    private String p2;
    private String p3;
    private String p4;

    @Override
    public String toString() {
        return "" +
                "jour='" + jour  +", p1='" + p1 +", p2='" + p2 +", p3='" + p3 +", p4='" + p4
                ;
    }
}
