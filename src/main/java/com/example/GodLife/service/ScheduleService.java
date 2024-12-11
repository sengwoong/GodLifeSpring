package com.example.GodLife.service;

import com.example.GodLife.Repository.ScheduleRepository;
import com.example.GodLife.Repository.UserRepository;
import com.example.GodLife.module.Schedule;
import com.example.GodLife.module.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    public ScheduleService(ScheduleRepository scheduleRepository, UserRepository userRepository) {
        this.scheduleRepository = scheduleRepository;
        this.userRepository = userRepository;
    }

    public Schedule createSchedule(Long userId, Schedule schedule) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
        schedule.setUser(user);
        return scheduleRepository.save(schedule);
    }

    public List<Schedule> getSchedulesByUserId(Long userId) {
        return scheduleRepository.findByUser_UserId(userId);
    }

    public void deleteSchedule(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new EntityNotFoundException("Schedule not found with id: " + scheduleId));
        scheduleRepository.delete(schedule);
    }
}
