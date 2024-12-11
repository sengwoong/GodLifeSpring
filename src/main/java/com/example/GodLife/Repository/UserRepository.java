package com.example.GodLife.Repository;

import com.example.GodLife.module.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
