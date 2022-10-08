package com.example.capstoneprojectbe.service;

import com.example.capstoneprojectbe.dto.WorkScheduleDto;
import com.example.capstoneprojectbe.model.WorkSchedule;
import com.example.capstoneprojectbe.repository.UserRepository;
import com.example.capstoneprojectbe.repository.WorkScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkScheduleService {
    private final WorkScheduleRepository workScheduleRepository;

    private final UserRepository userRepository;

    public WorkScheduleService(WorkScheduleRepository workScheduleRepository, UserRepository userRepository) {
        this.workScheduleRepository = workScheduleRepository;
        this.userRepository = userRepository;
    }


    public boolean isExisted(String id) {
        return workScheduleRepository.existsById(id);
    }

//    public boolean isExistedUserIDAndDateAndShift(String userID, String date, String shift) {
//        boolean check = false;
//        List<WorkingHour> listWorkHour = workingHourRepository.findAll();
//        for (int i = 1; i < listWorkHour.size(); i++) {
//            WorkingHour dtoCheck = listWorkHour.get(i);
//            if(userID.equals(dtoCheck.getUser().getUserID()) && date.equals(dtoCheck.getDate()) && shift.equals(dtoCheck.getShift())) {
//                check = true;
//                break;
//            }
//        }
//        return check;
//    }

    public boolean createWorkSchedule(WorkScheduleDto dto) {
        if (isExisted(dto.getWorkScheduleID())) {
            return false;
        }
        WorkSchedule workSchedule = new WorkSchedule();
        workSchedule.setWorkScheduleID(dto.getWorkScheduleID());
        workSchedule.setUser(userRepository.getById(dto.getUserID()));
        workSchedule.setDate(dto.getDate());
        workSchedule.setShift1(dto.isShift1());
        workSchedule.setShift2(dto.isShift2());
        workSchedule.setShift3(dto.isShift3());
        workScheduleRepository.save(workSchedule);
        return true;
    }


    public List<WorkSchedule> getAll() {
        return workScheduleRepository.findAll();
    }

    public void update(WorkScheduleDto dto) {
        WorkSchedule workSchedule = new WorkSchedule();
        workSchedule.setWorkScheduleID(dto.getWorkScheduleID());
        workSchedule.setUser(userRepository.getById(dto.getUserID()));
        workSchedule.setDate(dto.getDate());
        workSchedule.setShift1(dto.isShift1());
        workSchedule.setShift2(dto.isShift2());
        workSchedule.setShift3(dto.isShift3());
        workScheduleRepository.save(workSchedule);
    }

    public void delete(String id) {
        workScheduleRepository.deleteById(id);
    }

    public List<WorkSchedule> getByUserId(String id) {
        return workScheduleRepository.getWorkScheduleByUserID(id);
    }
}
