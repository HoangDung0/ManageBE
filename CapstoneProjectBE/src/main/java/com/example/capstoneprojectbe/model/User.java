package com.example.capstoneprojectbe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter// lombook
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "tbl_user")
public class User {
    @Id
    private String userID;

    private String userName;

    private String password;

    private String fullName;

    private String phoneNumber;

    private String sex;

    private String dayOfBirth;

    private String address;

    private String email;

//    private String storeID;

    private boolean status;



    // relationship role - user: 1-N
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roleID")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Role role;

    // relationship role - user: 1-N
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storeID")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Store store;



    // relationship user - workhistory: 1 - N
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Set<WorkHistory> workHistories = new HashSet<>();

    // relationship user - working hour:  1 - N
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Set<WorkingHour> workingHours = new HashSet<>();


    // relationship user - plan:  1 - N
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Set<Plan> plans = new HashSet<>();


    // relationship user - reward and discipline:  1 - N
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Set<RewardAndDiscipline> rewardAndDiscliplines = new HashSet<>();

    // relationship user - certificate:  1 - N
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Set<Certificates> certificates = new HashSet<>();

    // relationship user - work schedule:  1 - N
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Set<WorkSchedule> workSchedules = new HashSet<>();

    // relationship user - assessmentemployee:  1 - N
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Set<EmployeeAssessment> employeeAssessments = new HashSet<>();





}

    