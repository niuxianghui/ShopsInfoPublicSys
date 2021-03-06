package com.zzu.repository;

import com.zzu.model.Good;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by niuxianghui on 17/3/21.
 */
public interface GoodRepository extends JpaRepository<Good, Long> {
    List<Good> findByMerchantId(long id);
}
