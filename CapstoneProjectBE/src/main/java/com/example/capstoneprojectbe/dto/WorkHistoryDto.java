package com.example.capstoneprojectbe.dto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
public class WorkHistoryDto {

    @Id
    private String workHistoryID;

    private String userID;

    private String storeID;

    private String dateIn;

    private String dateOut;

    private boolean status;
}
