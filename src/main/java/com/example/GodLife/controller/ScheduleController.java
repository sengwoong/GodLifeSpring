package com.example.GodLife.controller;
import com.example.GodLife.module.Schedule;
import com.example.GodLife.service.ScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping("/users/{userId}")
    public ResponseEntity<Schedule> createSchedule(@PathVariable Long userId, @RequestBody Schedule schedule) {
        return ResponseEntity.ok(scheduleService.createSchedule(userId, schedule));
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Schedule>> getSchedulesByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(scheduleService.getSchedulesByUserId(userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);
        return ResponseEntity.noContent().build();
    }
}
