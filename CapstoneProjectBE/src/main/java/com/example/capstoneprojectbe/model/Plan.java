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
@Table(name = "tbl_plan")
public class Plan implements Serializable {
    @Id
    private String planID;

//    private String userID;

    private String date;

    private String shift;

    private String description;

    private int numberOfEmployee;

    private boolean status;

    // relationship plan - user: n-1
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userID")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private User user;
}
