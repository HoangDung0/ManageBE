package com.example.capstoneprojectbe.controller;

import com.example.capstoneprojectbe.dto.RoleDto;
import com.example.capstoneprojectbe.model.Role;
import com.example.capstoneprojectbe.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/role")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }
    @PostMapping("/create")
    public ResponseEntity createRole(@RequestBody RoleDto dto) {// lấy dữ liệu tryền vào dto
        if(roleService.isExisted(dto.getId())){
            return ResponseEntity.badRequest().body("Role Id is duplicated");
        }
        // tạo annoation//?
        roleService.createRole(dto);
        return ResponseEntity.ok().body("Successful");
    }
    @GetMapping
    private ResponseEntity getAll() {
        List<Role> roleList = roleService.getAll();
        return ResponseEntity.ok().body(roleList);
    }

    @PutMapping
    private ResponseEntity update(@RequestBody RoleDto dto) {
        roleService.update(dto);
        return ResponseEntity.ok().body("Successful");
    }

    @DeleteMapping()
    private ResponseEntity delete(@RequestParam String id) {
        roleService.delete(id);
        return ResponseEntity.ok().body("Successful");
    }

    @GetMapping("/get-by-id")
    private ResponseEntity getById(@RequestParam String id) {
        Role role = roleService.getById(id);
        return ResponseEntity.ok().body(role);
    }
}
