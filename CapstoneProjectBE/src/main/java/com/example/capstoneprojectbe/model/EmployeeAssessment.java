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
@Table(name = "tbl_employeeassessment")
public class EmployeeAssessment {

    @Id
    private String assessmentID;

//    private String userID;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userID")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private User user;
}
