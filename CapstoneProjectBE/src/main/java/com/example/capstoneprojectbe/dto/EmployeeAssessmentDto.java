package com.example.capstoneprojectbe.dto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeAssessmentDto {
    private String assessmentID;

    private String userID;

    private String date;

    private int employeeHonesty;

    private int enthusiasmAtWork;

    private int respectColleaguesAndCustomers;

    private int timeManagement;

    private int progressiveWill;

    private int becarefullAtWork;

    private int growAtWork;

    private int levelOfWorkCompletion;

    private String description;

    private int total;


}
