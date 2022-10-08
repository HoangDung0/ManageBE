package com.example.capstoneprojectbe.repository;

import com.example.capstoneprojectbe.model.RegistrationSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationScheduleRepository extends JpaRepository<RegistrationSchedule, String>  {
    @Query("select rs from RegistrationSchedule rs where rs.user.userID = ?1")
    List<RegistrationSchedule> getRegistrationScheduleByUserID(String userID);

    @Query("select rs from RegistrationSchedule rs inner join User us on rs.user.userID = us.userID " +
            "where us.role.id = ?2 and rs.date = ?1 " +
            "and rs.allday = false  " +
            "and rs.shift3 = true ")
    List<RegistrationSchedule> getRegistrationScheduleByDateAndRoleAndShift3(String date,
                                                                    String roleId);

    @Query("select rs from RegistrationSchedule rs inner join User us on rs.user.userID = us.userID " +
            "where us.role.id = ?2 and rs.date = ?1 " +
            "and rs.allday = false " +
            "and rs.shift2 = true ")
    List<RegistrationSchedule> getRegistrationScheduleByDateAndRoleAndShift2(String date,
                                                                    String roleId);

    @Query("select rs from RegistrationSchedule rs inner join User us on rs.user.userID = us.userID " +
            "where us.role.id = ?2 and rs.date = ?1 " +
            "and rs.allday = false and rs.shift1 = true ")
    List<RegistrationSchedule> getRegistrationScheduleByDateAndRoleAndShift1(String date,
                                                                    String roleId);

    @Query("select rs from RegistrationSchedule rs inner join User us on rs.user.userID = us.userID " +
            "where us.role.id = '3' and rs.date = ?1 " +
            "and rs.allday = true and us.userID = ?2 ")
    RegistrationSchedule isDayOffFullTimeStaff(String date,
                                                                             String userId);

    @Query("select rs from RegistrationSchedule rs")
    List<RegistrationSchedule> getAllRegistrationSchedule();


    @Query ("select rs from User u inner join RegistrationSchedule rs on u.userID = rs.user.userID")
    List<RegistrationSchedule> getRegistrationScheduleInnerUserID();

}
