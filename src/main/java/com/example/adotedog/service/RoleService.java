package com.example.adotedog.service;

import com.example.adotedog.enums.RoleUser;
import com.example.adotedog.model.RoleModel;
import com.example.adotedog.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RoleService {

    @Autowired
    private RoleRepository repository;

    public void saveRole() {
        repository.saveAll(List.of(new RoleModel(RoleUser.ADMIN), new RoleModel(RoleUser.USER)));
    }

    public RoleModel findByRoleName(RoleUser roleUser) {
        return repository.findByRole(roleUser)
                .orElseThrow(() -> new RuntimeException("Role não encontrada"));
    }

    public List<RoleModel> findALl() {
        return repository.findAll();
    }
}
