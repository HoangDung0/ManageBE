package com.example.capstoneprojectbe.service;

import com.example.capstoneprojectbe.dto.PlanDto;
import com.example.capstoneprojectbe.model.Plan;
import com.example.capstoneprojectbe.repository.PlanRepository;
import com.example.capstoneprojectbe.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanService {
    private final PlanRepository planRepository;

    private final UserRepository userRepository;

    public PlanService(PlanRepository planRepository, UserRepository userRepository) {
        this.planRepository = planRepository;
        this.userRepository = userRepository;
    }

    public Plan getPlanByDateAndShift(String date, String shift) {
        return planRepository.getPlanByDateAndShift(date,shift);
    }
    public boolean isExisted(String id) {
        return planRepository.existsById(id);
    }

    public boolean isExistedUserIDAndDateAndShift(String userID, String date, String shift) {
        boolean check = false;
        List<Plan> listPlan = planRepository.findAll();
        for (int i = 1; i < listPlan.size(); i++) {
            Plan dtoCheck = listPlan.get(i);
            if(userID.equals(dtoCheck.getUser().getUserID()) && date.equals(dtoCheck.getDate()) && shift.equals(dtoCheck.getShift())) {
                check = true;
                break;
            }
        }
        return check;
    }

    public void createPlan(PlanDto dto) {
        Plan plan = new Plan();
        plan.setPlanID(dto.getPlanID());
        plan.setUser(userRepository.getById(dto.getUserID()));
        plan.setDate(dto.getDate());
        plan.setShift(dto.getShift());
        plan.setDescription(dto.getDescription());
        plan.setNumberOfEmployee(dto.getNumberOfEmployee());
        plan.setStatus(dto.isStatus());
        planRepository.save(plan);
    }


    public List<Plan> getAll() {
        return planRepository.findAll();
    }

    public List<Plan> getPlanByDate(String date1, String date2){
        return  planRepository.getPlanByDate(date1,date2);

    }

    public void update(PlanDto dto) {
        Plan plan = new Plan();
        plan.setPlanID(dto.getPlanID());
        plan.setUser(userRepository.getById(dto.getUserID()));
        plan.setDate(dto.getDate());
        plan.setShift(dto.getShift());
        plan.setDescription(dto.getDescription());
        plan.setNumberOfEmployee(dto.getNumberOfEmployee());
        plan.setStatus(dto.isStatus());
        planRepository.save(plan);

    }

    public void delete(String id) {
        planRepository.deleteById(id);
    }

    public List<Plan> getByUserId(String id) {
        return planRepository.getPlanByUserID(id);
    }

}
