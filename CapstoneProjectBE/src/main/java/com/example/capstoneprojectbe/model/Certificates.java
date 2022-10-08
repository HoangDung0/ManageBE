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
@Table(name = "tbl_certificates")
public class Certificates {
    @Id
    private String certificateID;

//    private String userID;

    private String certificateName;

    private String date;

    private String image;

    private boolean status;

    // relationship certificate - user: n-1
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userID")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private User user;
}
