package com.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BridgeCpn {
    private Integer bri_cpn_no;
    private Integer bri_part_no;
    private String bri_cpn_name;
}
