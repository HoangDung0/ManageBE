package com.example.capstoneprojectbe.controller;

import com.example.capstoneprojectbe.dto.WorkScheduleDto;
import com.example.capstoneprojectbe.model.Plan;
import com.example.capstoneprojectbe.model.RegistrationSchedule;
import com.example.capstoneprojectbe.model.User;
import com.example.capstoneprojectbe.model.WorkSchedule;
import com.example.capstoneprojectbe.service.PlanService;
import com.example.capstoneprojectbe.service.RegistrationScheduleService;
import com.example.capstoneprojectbe.service.UserService;
import com.example.capstoneprojectbe.service.WorkScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api/workschedule")
public class WorkScheduleController {
    private final WorkScheduleService workScheduleService;
    private PlanService planService;
    private UserService userService;
    private RegistrationScheduleService registrationScheduleService;

    public WorkScheduleController(WorkScheduleService workScheduleService,
                                  PlanService planService,
                                  UserService userService,
                                  RegistrationScheduleService registrationScheduleService) {
        this.workScheduleService = workScheduleService;
        this.planService = planService;
        this.userService = userService;
        this.registrationScheduleService = registrationScheduleService;

    }


    @PostMapping("/create")
    public ResponseEntity createWorkSchedule() {// lấy dữ liệu tryền vào dto
        List<WorkScheduleDto> listWork = new ArrayList<>();
        List<String> listDate = new ArrayList<>();
        for (int i = 3; i <= 9; i++) {
            listDate.add("2022-10-0" + i);
        }
        List<String> listShift = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            listShift.add(i + "");
        }
        for (String date : listDate
        ) {
            List<User> listUserFullTime = userService.getAllFullTime();
            if (listUserFullTime.size() > 0)
            for (User user : listUserFullTime
            ) {
                String uniqueID = UUID.randomUUID().toString();
                WorkScheduleDto dto = new WorkScheduleDto();
                if (Objects.isNull(registrationScheduleService.isDayOffFullTimeStaff(date, user.getUserID()))) {
                    int x = (int) (Math.random() * 100);
                    dto.setWorkScheduleID(uniqueID);
                    dto.setDate(date);
                    if (x % 2 == 0) {
                        dto.setShift1(true);
                        dto.setShift2(true);
                        dto.setShift3(false);
                        dto.setUserID(user.getUserID());
                    } else {
                        dto.setUserID(user.getUserID());
                        dto.setShift1(false);
                        dto.setShift2(true);
                        dto.setShift3(true);
                    }
                    listWork.add(dto);
                } else {
                    dto.setWorkScheduleID(uniqueID);
                    dto.setDate(date);
                    dto.setUserID(user.getUserID());
                    dto.setShift1(false);
                    dto.setShift2(false);
                    dto.setShift3(false);
                    listWork.add(dto);
                }
            }
            for (String shift : listShift
            ) {
                List<RegistrationSchedule> listRegistPartTime = new ArrayList<>();
                List<RegistrationSchedule> listRegist = new ArrayList<>();
                Plan plan = planService.getPlanByDateAndShift(date, shift);
                int count = 0;
                if (shift.equals("1")) {
                    List<WorkScheduleDto> workSchedules = listWork.stream().filter(x -> x.getDate().equals(date) && x.isShift1()).collect(Collectors.toList());
                    count = Objects.nonNull(workSchedules) ? workSchedules.size() : 0;
                }
                if (shift.equals("2")) {
                    List<WorkScheduleDto> workSchedules = listWork.stream().filter(x -> x.getDate().equals(date) && x.isShift2()).collect(Collectors.toList());
                    count = Objects.nonNull(workSchedules) ? workSchedules.size() : 0;
                }
                if (shift.equals("3")) {
                    List<WorkScheduleDto> workSchedules = listWork.stream().filter(x -> x.getDate().equals(date) && x.isShift3()).collect(Collectors.toList());
                    count = Objects.nonNull(workSchedules) ? workSchedules.size() : 0;
                }
                if (plan != null) {
                    if (plan.getNumberOfEmployee() == 0) {
                        plan.setNumberOfEmployee(4);
                    }
                    if (plan.getNumberOfEmployee() > 0) {
                        if (shift.equals("1")) {
                            listRegistPartTime = registrationScheduleService.getListRegistrationByDateAndRoleShift1(date, "4");
                        }
                        if (shift.equals("2")) {
                            listRegistPartTime = registrationScheduleService.getListRegistrationByDateAndRoleShift2(date, "4");
                        }
                        if (shift.equals("3")) {
                            listRegistPartTime = registrationScheduleService.getListRegistrationByDateAndRoleShift3(date, "4");
                        }

                        if (plan.getNumberOfEmployee() > count) {
                            for (int i = 0; i < (plan.getNumberOfEmployee() - count); i++) {
                                if (listRegistPartTime.size() > 0 && i <= (listRegistPartTime.size() - 1)) {
                                    listRegist.add(listRegistPartTime.get(i));
                                }
                            }
                        }
                        if (listRegist.size() > 0) {
                            for (int i = 0; i < listRegist.size(); i++) {
                                List<RegistrationSchedule> finalListRegist = listRegist;
                                int finalI = i;
                                String uniqueID = UUID.randomUUID().toString();
                                WorkScheduleDto dto = new WorkScheduleDto();
                                    WorkScheduleDto exist = listWork.stream().filter(x -> x.getDate().equals(date)
                                            && x.getUserID().equals(finalListRegist.get(finalI).getUser().getUserID())).findAny().orElse(null);
                                    if (Objects.nonNull(exist)) {
                                        dto = exist;
                                        if (exist.isShift1() && !exist.isShift2() && !exist.isShift3()) {
                                            if (listRegist.get(i).isShift2()) {
                                                dto.setShift2(true);
                                            }
                                        }
                                        if (!exist.isShift1()) {
                                            if (listRegist.get(i).isShift3()) {
                                                dto.setShift3(true);
                                            }
                                        } else if (!exist.isShift2()){
                                            Set<RegistrationSchedule> rs = new HashSet<>(listRegistPartTime);
                                            rs.removeAll(listRegist);
                                            if (Objects.nonNull(rs)) {
                                                listRegist.add(rs.stream().iterator().next());
                                            }

                                        }
                                        listWork.remove(exist);
                                        listWork.add(dto);
                                    } else {
                                        if (shift.equals("1")) {
                                            dto.setShift1(listRegist.get(i).isShift1());
                                            dto.setShift3(false);
                                            dto.setShift2(false);
                                        }
                                        if (shift.equals("2")) {
                                            dto.setShift1(false);
                                            dto.setShift3(false);
                                            dto.setShift2(listRegist.get(i).isShift2());
                                        }
                                        if (shift.equals("3")) {
                                            dto.setShift1(false);
                                            dto.setShift3(listRegist.get(i).isShift3());
                                            dto.setShift2(false);
                                        }
                                        dto.setUserID(listRegist.get(i).getUser().getUserID());
                                        dto.setDate(date);
                                        dto.setWorkScheduleID(uniqueID);
                                        listWork.add(dto);
                                    }
                            }
                        }
                    }
                }
            }

        }

        boolean check = false;
        for (WorkScheduleDto workSchedule : listWork
        ) {
            check = workScheduleService.createWorkSchedule(workSchedule);
        }
        if (check) {
            return ResponseEntity.ok().body("Successful");
        } else {
            return ResponseEntity.badRequest().body("Bad Request");
        }
    }

    @GetMapping
    private ResponseEntity getAll() {
        List<WorkSchedule> workSchedulesList = workScheduleService.getAll();
        return ResponseEntity.ok().body(workSchedulesList);
    }

    @PutMapping
    private ResponseEntity update(@RequestBody WorkScheduleDto dto) {
        workScheduleService.update(dto);
        return ResponseEntity.ok().body("Successful");
    }

    @DeleteMapping()
    private ResponseEntity delete(@RequestParam String id) {
        workScheduleService.delete(id);
        return ResponseEntity.ok().body("Successful");
    }

    @GetMapping("/get-by-user-id")
    private ResponseEntity getByUserId(@RequestParam String id) {
        List<WorkSchedule> workScheduleList = workScheduleService.getByUserId(id);
        return ResponseEntity.ok().body(workScheduleList);
    }
}
