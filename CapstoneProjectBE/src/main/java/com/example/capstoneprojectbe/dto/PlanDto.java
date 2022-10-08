package com.example.capstoneprojectbe.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PlanDto {

    private String planID;

    private String userID;

    private String date;

    private String shift;

    private String description;

    private int numberOfEmployee;

    private boolean status;

}
