package com.example.capstoneprojectbe.service;

import com.example.capstoneprojectbe.dto.WorkingHourDto;
import com.example.capstoneprojectbe.model.WorkingHour;
import com.example.capstoneprojectbe.repository.UserRepository;
import com.example.capstoneprojectbe.repository.WorkScheduleRepository;
import com.example.capstoneprojectbe.repository.WorkingHourRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkingHourService {

    private final WorkingHourRepository workingHourRepository;

    private final UserRepository userRepository;

    private final WorkScheduleRepository workScheduleRepository;

    public WorkingHourService(WorkingHourRepository workingHourRepository, UserRepository userRepository, WorkScheduleRepository workScheduleRepository) {
        this.workingHourRepository = workingHourRepository;
        this.userRepository = userRepository;
        this.workScheduleRepository = workScheduleRepository;
    }


    public boolean isExisted(String id) {
        return workingHourRepository.existsById(id);
    }

//    public boolean isExistedUserIDAndDateAndShift(String userID, String workScheduleID) {
//        boolean check = false;
//        List<WorkingHour> listWorkHour = workingHourRepository.findAll();
//        for (int i = 1; i < listWorkHour.size(); i++) {
//            WorkingHour dtoCheck = listWorkHour.get(i);
//            if(userID.equals(dtoCheck.getUser().getUserID()) && workScheduleID.equals(dtoCheck.getWorkSchedule().getWorkScheduleID())) {
//                check = true;
//                break;
//            }
//        }
//        return check;
//    }

    public void createWorkingHour(WorkingHourDto dto) {
        WorkingHour workingHour = new WorkingHour();
        workingHour.setWorkingHourID(dto.getWorkingHourID());
        workingHour.setUser(userRepository.getById(dto.getUserID()));
//        workingHour.setDate(dto.getDate());
//        workingHour.setShift(dto.getShift());
        workingHour.setWorkSchedule(workScheduleRepository.getById(dto.getWorkScheduleID()));
        workingHour.setTimeIn(dto.getTimeIn());
        workingHour.setTimeOut(dto.getTimeOut());
        workingHour.setTotalWorkingHour(dto.getTotalWorkingHour());
        workingHour.setWorkingHourStatus(dto.isWorkingHourStatus());
        workingHourRepository.save(workingHour);
    }


    public List<WorkingHour> getAllWorkingHour() {
        return workingHourRepository.getAllWorkingHour();
//        return workingHourRepository.findAll();
    }

    public void update(WorkingHourDto dto) {
        WorkingHour workingHour = new WorkingHour();
        workingHour.setWorkingHourID(dto.getWorkingHourID());
        workingHour.setUser(userRepository.getById(dto.getUserID()));
//        workingHour.setDate(dto.getDate());
//        workingHour.setShift(dto.getShift());
        workingHour.setWorkSchedule(workScheduleRepository.getById(dto.getWorkScheduleID()));
        workingHour.setTimeIn(dto.getTimeIn());
        workingHour.setTimeOut(dto.getTimeOut());
        workingHour.setTotalWorkingHour(dto.getTotalWorkingHour());
        workingHour.setWorkingHourStatus(dto.isWorkingHourStatus());
        workingHourRepository.save(workingHour);


    }

    public void delete(String id) {
        workingHourRepository.deleteById(id);
    }

    public List<WorkingHour> getByUserId(String id) {
        return workingHourRepository.getWorkingHourByUserID(id);
    }



}
