package com.example.capstoneprojectbe.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@NoArgsConstructor
public class WorkingHourDto {

    private String workingHourID;

    private String userID;

//    private String date;
//
//    private String shift;

    private String workScheduleID;

    private String timeIn;

    private String timeOut;

    private float totalWorkingHour;

    private boolean workingHourStatus;
}
