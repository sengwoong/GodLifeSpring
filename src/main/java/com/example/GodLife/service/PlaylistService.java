package com.example.GodLife.service;

import com.example.GodLife.Repository.PlaylistRepository;
import com.example.GodLife.Repository.UserRepository;
import com.example.GodLife.module.Playlist;
import com.example.GodLife.module.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlaylistService {
    private final PlaylistRepository playlistRepository;
    private final UserRepository userRepository;

    public PlaylistService(PlaylistRepository playlistRepository, UserRepository userRepository) {
        this.playlistRepository = playlistRepository;
        this.userRepository = userRepository;
    }

    public Playlist createPlaylist(Long userId, Playlist playlist) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
        playlist.setUser(user);
        return playlistRepository.save(playlist);
    }

    public List<Playlist> getPlaylistsByUserId(Long userId) {
        return playlistRepository.findByUserId(userId);
    }

    public void deletePlaylist(Long playlistId) {
        Playlist playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new EntityNotFoundException("Playlist not found with id: " + playlistId));
        playlistRepository.delete(playlist);
    }
}
