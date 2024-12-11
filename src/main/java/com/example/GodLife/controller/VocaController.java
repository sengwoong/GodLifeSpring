package com.example.GodLife.controller;
import com.example.GodLife.module.Voca;
import com.example.GodLife.service.VocaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vocas")
public class VocaController {
    private final VocaService vocaService;

    public VocaController(VocaService vocaService) {
        this.vocaService = vocaService;
    }

    @PostMapping("/users/{userId}")
    public ResponseEntity<Voca> createVoca(@PathVariable Long userId, @RequestBody Voca voca) {
        return ResponseEntity.ok(vocaService.createVoca(userId, voca));
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Voca>> getVocasByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(vocaService.getVocasByUserId(userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVoca(@PathVariable Long id) {
        vocaService.deleteVoca(id);
        return ResponseEntity.noContent().build();
    }
}
