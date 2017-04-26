package com.zzu.repository;

import com.zzu.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by niuxianghui on 17/4/25.
 */
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByName(String name);
}
