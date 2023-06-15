package com.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnitJob {
    private Integer unit_no;
    private String bridge_no;
    private String unit_job;

}
