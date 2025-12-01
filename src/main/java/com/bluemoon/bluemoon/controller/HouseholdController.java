package com.bluemoon.bluemoon.controller;

import com.bluemoon.bluemoon.entity.Household;
import com.bluemoon.bluemoon.service.HouseholdService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/households")
public class HouseholdController {

    private final HouseholdService householdService;

    public HouseholdController(HouseholdService householdService) {
        this.householdService = householdService;
    }

    @PostMapping
    public ResponseEntity<Household> create(@RequestBody Household household) {
        return ResponseEntity.ok(householdService.create(household));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Household> update(@PathVariable Long id,
                                            @RequestBody Household household) {
        return ResponseEntity.ok(householdService.update(id, household));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        householdService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Household> getById(@PathVariable Long id) {
        return ResponseEntity.ok(householdService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Household>> getAll() {
        return ResponseEntity.ok(householdService.getAll());
    }

    @GetMapping("/active")
    public ResponseEntity<List<Household>> getActive() {
        return ResponseEntity.ok(householdService.getActive());
    }

    @GetMapping("/by-apartment")
    public ResponseEntity<List<Household>> getByApartment(@RequestParam String apartmentNumber) {
        return ResponseEntity.ok(householdService.getByApartment(apartmentNumber));
    }
}
