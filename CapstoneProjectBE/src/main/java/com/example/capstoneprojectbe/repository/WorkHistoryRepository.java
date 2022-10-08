package com.example.capstoneprojectbe.repository;

import com.example.capstoneprojectbe.model.WorkHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkHistoryRepository extends JpaRepository<WorkHistory, String> {

    @Query("select workHistory from WorkHistory workHistory where workHistory.user.userID = ?1")
    List<WorkHistory> getWorkHistoriesByUserID(String userID);

    @Query("select workHistory from WorkHistory workHistory where workHistory.store.storeID = ?1")
    List<WorkHistory> getWorkHistoriesByStoreID(String storeID);

    @Query("select workHistory from WorkHistory workHistory")
    List<WorkHistory> getAllWorkHistory();

}
