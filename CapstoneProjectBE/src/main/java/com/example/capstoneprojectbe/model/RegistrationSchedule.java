package com.example.capstoneprojectbe.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Getter// lombook
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_registrationschedule")
public class RegistrationSchedule {

    @Id
    private String registrationScheduleID;

//    private String userID;

    private String date;

    private boolean shift1;

    private boolean shift2;

    private boolean shift3;

    private boolean allday;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userID")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private User user;

}
