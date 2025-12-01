package com.bluemoon.bluemoon.controller;

import com.bluemoon.bluemoon.entity.Resident;
import com.bluemoon.bluemoon.service.ResidentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/residents")
public class ResidentController {

    private final ResidentService residentService;

    public ResidentController(ResidentService residentService) {
        this.residentService = residentService;
    }

    @PostMapping
    public ResponseEntity<Resident> create(@RequestBody Resident resident) {
        return ResponseEntity.ok(residentService.create(resident));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resident> update(@PathVariable Long id,
                                           @RequestBody Resident resident) {
        return ResponseEntity.ok(residentService.update(id, resident));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        residentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resident> getById(@PathVariable Long id) {
        return ResponseEntity.ok(residentService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Resident>> getAll() {
        return ResponseEntity.ok(residentService.getAll());
    }

    @GetMapping("/by-household/{householdId}")
    public ResponseEntity<List<Resident>> getByHousehold(@PathVariable Long householdId) {
        return ResponseEntity.ok(residentService.getByHousehold(householdId));
    }

    @GetMapping("/by-status")
    public ResponseEntity<List<Resident>> getByStatus(@RequestParam String status) {
        return ResponseEntity.ok(residentService.getByResidenceStatus(status));
    }
}
