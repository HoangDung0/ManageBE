package com.example.capstoneprojectbe.repository;


import com.example.capstoneprojectbe.model.WorkingHour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkingHourRepository extends JpaRepository<WorkingHour, String>{

    @Query("select workingHour from WorkingHour workingHour where workingHour.user.userID = ?1")
    List<WorkingHour> getWorkingHourByUserID(String userID);

    @Query("select workingHour from WorkingHour workingHour")
    List<WorkingHour> getAllWorkingHour();
}

