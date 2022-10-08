package com.example.capstoneprojectbe.dto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WorkScheduleDto {
    private String workScheduleID;

    private String userID;

    private String date;

    private boolean shift1;

    private boolean shift2;

    private boolean shift3;

}
