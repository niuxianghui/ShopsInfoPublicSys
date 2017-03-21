package com.zzu.repository;

import com.zzu.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by niuxianghui on 17/3/21.
 */

public interface UserRepository extends JpaRepository<User, Long>{
    User findById(Long id);
}
