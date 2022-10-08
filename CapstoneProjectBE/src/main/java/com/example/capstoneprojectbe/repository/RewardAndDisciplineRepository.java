package com.example.capstoneprojectbe.repository;

import com.example.capstoneprojectbe.model.RewardAndDiscipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RewardAndDisciplineRepository extends JpaRepository<RewardAndDiscipline, String>{

    @Query("select rad from RewardAndDiscipline rad where rad.user.userID = ?1")
    List<RewardAndDiscipline> getRewardAndDisciplineByUserID(String userID);

}
