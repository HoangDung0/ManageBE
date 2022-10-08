package com.example.capstoneprojectbe.service;

import com.example.capstoneprojectbe.dto.RewardAndDisciplineDto;
import com.example.capstoneprojectbe.model.RewardAndDiscipline;
import com.example.capstoneprojectbe.repository.RewardAndDisciplineRepository;
import com.example.capstoneprojectbe.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewardAndDisciplineService {

    private final RewardAndDisciplineRepository rewardAndDisciplineRepository;

    private final UserRepository userRepository;

    public RewardAndDisciplineService(RewardAndDisciplineRepository rewardAndDisciplineRepository, UserRepository userRepository) {
        this.rewardAndDisciplineRepository = rewardAndDisciplineRepository;
        this.userRepository = userRepository;
    }


    public boolean isExisted(String id) {
        return rewardAndDisciplineRepository.existsById(id);
    }

//    public boolean isExistedUserIDAndDateAndShift(String userID, String date, String shift) {
//        boolean check = false;
//        List<Plan> listPlan = planRepository.findAll();
//        for (int i = 1; i < listPlan.size(); i++) {
//            Plan dtoCheck = listPlan.get(i);
//            if(userID.equals(dtoCheck.getUser().getUserID()) && date.equals(dtoCheck.getDate()) && shift.equals(dtoCheck.getShift())) {
//                check = true;
//                break;
//            }
//        }
//        return check;
//    }

    public void createRewardAndDiscipline(RewardAndDisciplineDto dto) {
        RewardAndDiscipline rewardAndDiscipline = new RewardAndDiscipline();
        rewardAndDiscipline.setRewardAndDisciplineID(dto.getRewardAndDisciplineID());
        rewardAndDiscipline.setUser(userRepository.getById(dto.getUserID()));
        rewardAndDiscipline.setDate(dto.getDate());
        rewardAndDiscipline.setTotalScoreAssessment(dto.getTotalScoreAssessment());
        rewardAndDiscipline.setType(dto.getType());
        rewardAndDiscipline.setDescription(dto.getDescription());
        rewardAndDiscipline.setAmount(dto.getAmount());
        rewardAndDisciplineRepository.save(rewardAndDiscipline);

    }


    public List<RewardAndDiscipline> getAll() {
        return rewardAndDisciplineRepository.findAll();
    }

    public void update(RewardAndDisciplineDto dto) {
        RewardAndDiscipline rewardAndDiscipline = new RewardAndDiscipline();
        rewardAndDiscipline.setRewardAndDisciplineID(dto.getRewardAndDisciplineID());
        rewardAndDiscipline.setUser(userRepository.getById(dto.getUserID()));
        rewardAndDiscipline.setDate(dto.getDate());
        rewardAndDiscipline.setTotalScoreAssessment(dto.getTotalScoreAssessment());
        rewardAndDiscipline.setType(dto.getType());
        rewardAndDiscipline.setDescription(dto.getDescription());
        rewardAndDiscipline.setAmount(dto.getAmount());
        rewardAndDisciplineRepository.save(rewardAndDiscipline);

    }

    public void delete(String id) {
        rewardAndDisciplineRepository.deleteById(id);
    }

    public List<RewardAndDiscipline> getByUserId(String id) {
        return rewardAndDisciplineRepository.getRewardAndDisciplineByUserID(id);
    }
}
