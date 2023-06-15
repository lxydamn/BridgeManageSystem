package com.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BridgeCetPart {
    private Integer cet_part_no;
    private String bridge_no;
    private String type_no;
    private Integer bri_cpn_no;
    private String cet_part_name;
}
