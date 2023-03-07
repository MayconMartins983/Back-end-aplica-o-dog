package com.example.adotedog.repository;

import com.example.adotedog.enums.RoleUser;
import com.example.adotedog.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository  extends JpaRepository<RoleModel, Long> {

    Optional<RoleModel> findByRole(RoleUser roleUser);
}
