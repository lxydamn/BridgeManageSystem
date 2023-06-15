package com.backend.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BridgeAccessRecord {
    private String ase_rcd_no;
    private String card_no;
    private String ase_type;
    private String ase_rst;
    private String ctr_mes;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date ase_time;
}
