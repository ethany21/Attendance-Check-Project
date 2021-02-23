package com.github.project.attendancecheck.repository;

import com.github.project.attendancecheck.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
