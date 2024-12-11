package com.example.GodLife.Repository;

import com.example.GodLife.module.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
    List<Playlist> findByUser_UserId(Long userId);
}