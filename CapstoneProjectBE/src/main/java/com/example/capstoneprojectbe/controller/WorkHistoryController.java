package com.example.capstoneprojectbe.controller;

import com.example.capstoneprojectbe.dto.WorkHistoryDto;
import com.example.capstoneprojectbe.model.WorkHistory;
import com.example.capstoneprojectbe.service.WorkHistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/workhistory")
public class WorkHistoryController {
    private final WorkHistoryService workHistoryService;

    public WorkHistoryController(WorkHistoryService workHistoryService) {
        this.workHistoryService = workHistoryService;
    }


    @PostMapping("/create")
    public ResponseEntity createWorkHistory(@RequestBody WorkHistoryDto dto) {// lấy dữ liệu tryền vào dto
        if(workHistoryService.isExisted(dto.getWorkHistoryID())){
            return ResponseEntity.badRequest().body("Id is duplicated");
        }
        if(workHistoryService.isExistedUserIDAndStoreID(dto.getUserID(), dto.getStoreID())){
            return ResponseEntity.badRequest().body("StoreID and UserID is duplicated");
        }
        // tạo annoation//?
        workHistoryService.createWorkHistory(dto);
        return ResponseEntity.ok().body("Successful");
    }
    @GetMapping
    private ResponseEntity getAll() {
        List<WorkHistory> workHistoryList = workHistoryService.getAll();
        return ResponseEntity.ok().body(workHistoryList);
    }

    @PutMapping
    private ResponseEntity update(@RequestBody WorkHistoryDto dto) {
        workHistoryService.update(dto);
        return ResponseEntity.ok().body("Successful");
    }

    @DeleteMapping()
    private ResponseEntity delete(@RequestParam String id) {
        workHistoryService.delete(id);
        return ResponseEntity.ok().body("Successful");
    }

    @GetMapping("/get-by-user-id")
    private ResponseEntity getByUserId(@RequestParam String id) {
        List<WorkHistory> workHistoryList = workHistoryService.getByUserId(id);
        return ResponseEntity.ok().body(workHistoryList);
    }

    @GetMapping("/get-by-store-id")
    private ResponseEntity getByStoreId(@RequestParam String id) {
        List<WorkHistory> workHistoryList = workHistoryService.getByStoreID(id);
        return ResponseEntity.ok().body(workHistoryList);
    }


}
