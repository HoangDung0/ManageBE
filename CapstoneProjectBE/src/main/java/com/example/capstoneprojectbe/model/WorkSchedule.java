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
@Table(name = "tbl_workschedule")
public class WorkSchedule {

    @Id
    private String workScheduleID;

//    private String userID;

    private String date;

    private boolean shift1;

    private boolean shift2;

    private boolean shift3;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userID")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})

    private User user;

    // relationship Work Schedule - WorkingHour: 1 - 1

    @OneToMany(mappedBy = "workSchedule")
    @JsonIgnore
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    //private WorkingHour workingHours;
    private Set<WorkingHour> workingHours = new HashSet<>();


}
