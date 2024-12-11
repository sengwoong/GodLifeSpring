package com.example.GodLife.controller;
import com.example.GodLife.module.Playlist;
import com.example.GodLife.service.PlaylistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {
    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @PostMapping("/users/{userId}")
    public ResponseEntity<Playlist> createPlaylist(@PathVariable Long userId, @RequestBody Playlist playlist) {
        return ResponseEntity.ok(playlistService.createPlaylist(userId, playlist));
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Playlist>> getPlaylistsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(playlistService.getPlaylistsByUserId(userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlaylist(@PathVariable Long id) {
        playlistService.deletePlaylist(id);
        return ResponseEntity.noContent().build();
    }
}
