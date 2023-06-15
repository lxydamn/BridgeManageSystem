package com.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BridgeInfo {
    private String bridge_no;
    private String type_no;
    private String peri_rcd_no;
    private String card_no;
    private Integer init_rcd_no;
    private Integer route_no;
    private String bridge_name;
}
