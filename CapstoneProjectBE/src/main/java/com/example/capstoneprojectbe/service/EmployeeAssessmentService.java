package com.example.capstoneprojectbe.service;

import com.example.capstoneprojectbe.dto.CertificatesDto;
import com.example.capstoneprojectbe.dto.EmployeeAssessmentDto;
import com.example.capstoneprojectbe.model.Certificates;
import com.example.capstoneprojectbe.model.EmployeeAssessment;
import com.example.capstoneprojectbe.repository.EmployeeAssessmentRepository;
import com.example.capstoneprojectbe.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeAssessmentService {

    private final EmployeeAssessmentRepository employeeAssessmentRepository;

    private final UserRepository userRepository;

    public EmployeeAssessmentService(EmployeeAssessmentRepository employeeAssessmentRepository, UserRepository userRepository) {
        this.employeeAssessmentRepository = employeeAssessmentRepository;
        this.userRepository = userRepository;
    }


    public boolean isExisted(String id) {
        return employeeAssessmentRepository.existsById(id);
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

    public void createEmployeeAssessment(EmployeeAssessmentDto dto) {
        EmployeeAssessment employeeAssessment = new EmployeeAssessment();
        employeeAssessment.setAssessmentID(dto.getAssessmentID());
        employeeAssessment.setUser(userRepository.getById(dto.getUserID()));
        employeeAssessment.setDate(dto.getDate());
        employeeAssessment.setEmployeeHonesty(dto.getEmployeeHonesty());
        employeeAssessment.setEnthusiasmAtWork(dto.getEnthusiasmAtWork());
        employeeAssessment.setRespectColleaguesAndCustomers(dto.getRespectColleaguesAndCustomers());
        employeeAssessment.setTimeManagement(dto.getTimeManagement());
        employeeAssessment.setProgressiveWill(dto.getProgressiveWill());
        employeeAssessment.setBecarefullAtWork(dto.getBecarefullAtWork());
        employeeAssessment.setGrowAtWork(dto.getGrowAtWork());
        employeeAssessment.setLevelOfWorkCompletion(dto.getLevelOfWorkCompletion());
        employeeAssessment.setDescription(dto.getDescription());
        employeeAssessment.setTotal(dto.getTotal());
        employeeAssessmentRepository.save(employeeAssessment);
    }


    public List<EmployeeAssessment> getAll() {
        return employeeAssessmentRepository.findAll();
    }

    public void update(EmployeeAssessmentDto dto) {
        EmployeeAssessment employeeAssessment = new EmployeeAssessment();
        employeeAssessment.setAssessmentID(dto.getAssessmentID());
        employeeAssessment.setUser(userRepository.getById(dto.getUserID()));
        employeeAssessment.setDate(dto.getDate());
        employeeAssessment.setEmployeeHonesty(dto.getEmployeeHonesty());
        employeeAssessment.setEnthusiasmAtWork(dto.getEnthusiasmAtWork());
        employeeAssessment.setRespectColleaguesAndCustomers(dto.getRespectColleaguesAndCustomers());
        employeeAssessment.setTimeManagement(dto.getTimeManagement());
        employeeAssessment.setProgressiveWill(dto.getProgressiveWill());
        employeeAssessment.setBecarefullAtWork(dto.getBecarefullAtWork());
        employeeAssessment.setGrowAtWork(dto.getGrowAtWork());
        employeeAssessment.setLevelOfWorkCompletion(dto.getLevelOfWorkCompletion());
        employeeAssessment.setDescription(dto.getDescription());
        employeeAssessment.setTotal(dto.getTotal());
        employeeAssessmentRepository.save(employeeAssessment);

    }

    public void delete(String id) {
        employeeAssessmentRepository.deleteById(id);
    }

    public List<EmployeeAssessment> getByUserId(String id) {
        return employeeAssessmentRepository.getEmployeeAssessmentByUserID(id);
    }

}
