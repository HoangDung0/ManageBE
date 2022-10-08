package com.example.capstoneprojectbe.repository;

import com.example.capstoneprojectbe.model.RegistrationSchedule;
import com.example.capstoneprojectbe.model.WorkSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkScheduleRepository extends JpaRepository<WorkSchedule, String>  {

    @Query("select workSchedule from WorkSchedule workSchedule " +
            "where workSchedule.user.userID = ?1")
    List<WorkSchedule> getWorkScheduleByUserID(String userID);
}