package com.example.capstoneprojectbe.controller;

import com.example.capstoneprojectbe.dto.StoreDto;
import com.example.capstoneprojectbe.model.Store;
import com.example.capstoneprojectbe.service.StoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/store")
public class StoreController {
    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping("/create")
    public ResponseEntity createStore(@RequestBody StoreDto dto) {// lấy dữ liệu tryền vào dto
        if(storeService.isExisted(dto.getStoreID())){
            return ResponseEntity.badRequest().body("Store Id is duplicated");
        }
        // tạo annoation//?
        storeService.createStore(dto);
        return ResponseEntity.ok().body("Successful");
    }
    @GetMapping
    private ResponseEntity getAll() {
        List<Store> storeList = storeService.getAll();
        return ResponseEntity.ok().body(storeList);
    }

    @PutMapping
    private ResponseEntity update(@RequestBody StoreDto dto) {
        storeService.update(dto);
        return ResponseEntity.ok().body("Successful");
    }

    @DeleteMapping()
    private ResponseEntity delete(@RequestParam String id) {
        storeService.delete(id);
        return ResponseEntity.ok().body("Successful");
    }

    @GetMapping("/get-by-id")
    private ResponseEntity getById(@RequestParam String id) {
        Store store = storeService.getById(id);
        return ResponseEntity.ok().body(store);
    }
}
