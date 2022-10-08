package com.example.capstoneprojectbe.service;

import com.example.capstoneprojectbe.dto.WorkHistoryDto;
import com.example.capstoneprojectbe.model.WorkHistory;
import com.example.capstoneprojectbe.repository.StoreRepository;
import com.example.capstoneprojectbe.repository.UserRepository;
import com.example.capstoneprojectbe.repository.WorkHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkHistoryService {
    private final WorkHistoryRepository workHistoryRepository;

    private final StoreRepository storeRepository;

    private final UserRepository userRepository;

    public WorkHistoryService(WorkHistoryRepository workHistoryRepository, StoreRepository storeRepository, UserRepository userRepository) {
        this.workHistoryRepository = workHistoryRepository;
        this.storeRepository = storeRepository;
        this.userRepository = userRepository;
    }


    public boolean isExisted(String id) {
        return workHistoryRepository.existsById(id);
    }

    public boolean isExistedUserIDAndStoreID(String userID, String storeID) {
        boolean check = false;
        List<WorkHistory> listWorkHistories = workHistoryRepository.getAllWorkHistory();
//        for (int i = 1; i < listWorkHistories.size(); i++) {
//            WorkHistory dtoCheck = listWorkHistories.get(i);
//            if(userID.equals(dtoCheck.getUser().getUserID()) && storeID.equals(dtoCheck.getStore().getStoreID())) {
//                check = true;
//                break;
//            }
//        }
//        return check;

        for (WorkHistory x : listWorkHistories) {
            if (userID.equals(x.getUser().getUserID()) && storeID.equals(x.getStore().getStoreID())) {
                check = true;
                break;
            }
        }
        return check;
    }

    public void createWorkHistory(WorkHistoryDto dto) {

        WorkHistory workHistory = new WorkHistory();
        workHistory.setWorkHistoryID(dto.getWorkHistoryID());
//        workHistory.setStoreID(dto.getStoreID());
        workHistory.setStore(storeRepository.getById(dto.getStoreID()));
//        workHistory.setUserID(dto.getUserID());
        workHistory.setUser(userRepository.getById(dto.getUserID()));
        workHistory.setDateIn(dto.getDateIn());
        workHistory.setDateOut(dto.getDateOut());
        workHistory.setStatus(dto.isStatus());
        workHistoryRepository.save(workHistory);
    }


    public List<WorkHistory> getAll() {
        return workHistoryRepository.findAll();
    }

    public void update(WorkHistoryDto dto) {

        WorkHistory workHistory = new WorkHistory();
        workHistory.setWorkHistoryID(dto.getWorkHistoryID());
        workHistory.setStore(storeRepository.getById((dto.getStoreID())));
        workHistory.setUser(userRepository.getById(dto.getUserID()));
        workHistory.setDateIn(dto.getDateIn());
        workHistory.setDateOut(dto.getDateOut());
        workHistory.setStatus(dto.isStatus());
        workHistoryRepository.save(workHistory);


    }

    public void delete(String id) {
        workHistoryRepository.deleteById(id);
    }

    public List<WorkHistory> getByUserId(String id) {
        return workHistoryRepository.getWorkHistoriesByUserID(id);
    }

    public List<WorkHistory> getByStoreID(String id) {
        return workHistoryRepository.getWorkHistoriesByStoreID(id);
    }

}
