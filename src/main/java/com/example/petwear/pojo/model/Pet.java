package com.example.petwear.pojo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author qiu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    private int petId;
    private String petName;
    private int masterId;
    private String petType;
    private int petHr;
    private int petSpo2;
    private int petTemp;
    private int petEcg;
    private int petWeight;
}
