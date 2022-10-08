package com.example.capstoneprojectbe.repository;

import com.example.capstoneprojectbe.model.Certificates;
import com.example.capstoneprojectbe.model.EmployeeAssessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeAssessmentRepository extends JpaRepository<EmployeeAssessment, String>{

    @Query("select ea from EmployeeAssessment ea where ea.user.userID = :userID")
    List<EmployeeAssessment> getEmployeeAssessmentByUserID(String userID);
}
