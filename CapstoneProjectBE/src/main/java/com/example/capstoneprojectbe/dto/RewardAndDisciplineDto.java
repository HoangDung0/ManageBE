package com.example.capstoneprojectbe.dto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RewardAndDisciplineDto {

    private String rewardAndDisciplineID;

    private String userID;

    private String date;

    private String totalScoreAssessment;

    private String type;

    private String description;

    private float amount;
}
