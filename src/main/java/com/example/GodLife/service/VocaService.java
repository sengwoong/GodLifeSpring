package com.example.GodLife.service;

import com.example.GodLife.Repository.UserRepository;
import com.example.GodLife.Repository.VocaRepository;
import com.example.GodLife.module.User;
import com.example.GodLife.module.Voca;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VocaService {
    private final VocaRepository vocaRepository;
    private final UserRepository userRepository;

    public VocaService(VocaRepository vocaRepository, UserRepository userRepository) {
        this.vocaRepository = vocaRepository;
        this.userRepository = userRepository;
    }

    public Voca createVoca(Long userId, Voca voca) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
        voca.setUser(user);
        return vocaRepository.save(voca);
    }

    public List<Voca> getVocasByUserId(Long userId) {
        return vocaRepository.findByUserId(userId);
    }

    public void deleteVoca(Long vocaId) {
        Voca voca = vocaRepository.findById(vocaId)
                .orElseThrow(() -> new EntityNotFoundException("Voca not found with id: " + vocaId));
        vocaRepository.delete(voca);
    }
}
