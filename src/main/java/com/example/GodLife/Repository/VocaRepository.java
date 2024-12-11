package com.example.GodLife.Repository;

import com.example.GodLife.module.Voca;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VocaRepository extends JpaRepository<Voca, Long> {
    List<Voca> findByUser_UserId(Long userId);
}
