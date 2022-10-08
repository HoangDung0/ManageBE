package com.example.capstoneprojectbe.dto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegistrationScheduleDto {
    private String registrationScheduleID;

    private String userID;

    private String date;

    private boolean shift1;

    private boolean shift2;

    private boolean shift3;

    private boolean allday;

}
