package com.lvadm.currency.exchange.repository;

import com.lvadm.currency.exchange.dbo.UsersDBO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UsersDBO, Integer> {

}
