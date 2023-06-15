package com.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaintainRecord {
    private String tre_rcd_no;
    private String card_no;
    private String tre_type;
    private String tre_rea;
    private String tre_rge;
    private Double pro_fee;
    private String ori_fee;
    private String tre_qlt_aes;

}
