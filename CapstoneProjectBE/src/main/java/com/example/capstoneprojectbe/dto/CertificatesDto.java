package com.example.capstoneprojectbe.dto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CertificatesDto {
    private String certificateID;

    private String userID;

    private String certificateName;

    private String date;

    private String image;

    private boolean status;

}
