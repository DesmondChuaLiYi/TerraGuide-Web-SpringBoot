package com.terraguide.terraguide_springboot.repository;

import com.terraguide.terraguide_springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
  // Add custom methods here if needed later
  User findByUsername(String username);
  User findByEmail(String email);
}
