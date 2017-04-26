package com.zzu.repository;

import com.zzu.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by niuxianghui on 17/3/21.
 */
public interface MerchantRepository extends JpaRepository<Merchant, Long> {
    Merchant findByUserName(String userName);
    List<Merchant> findByCategory(String category);
}
