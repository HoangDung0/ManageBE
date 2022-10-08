package com.example.capstoneprojectbe.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter// lombook
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_rewardanddiscipline")
public class RewardAndDiscipline {

    @Id
    private String rewardAndDisciplineID;

//    private String userID;

    private String date;

    private String totalScoreAssessment;

    private String type;

    private String description;

    private float amount;

    // relationship reward and discipline - user: n-1
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userID")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private User user;
}
