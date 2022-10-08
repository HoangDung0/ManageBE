package com.example.capstoneprojectbe.service;

import com.example.capstoneprojectbe.dto.RoleDto;
import com.example.capstoneprojectbe.model.Role;
import com.example.capstoneprojectbe.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    public boolean isExisted(String id) {
        return roleRepository.existsById(id);
    }

    public void createRole(RoleDto dto) {
        Role role = new Role();
        role.setId(dto.getId());
        role.setName(dto.getName());
        roleRepository.save(role);
    }

    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    public void update(RoleDto dto) {
        Role role = new Role();
        role.setId(dto.getId());
        role.setName(dto.getName());
        roleRepository.save(role);
    }

    public void delete(String id) {
        roleRepository.deleteById(id);
    }

    public Role getById(String id) {
        return roleRepository.getById(id);
    }
}
