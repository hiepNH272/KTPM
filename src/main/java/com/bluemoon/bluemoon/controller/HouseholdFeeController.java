package com.bluemoon.bluemoon.controller;

import com.bluemoon.bluemoon.entity.HouseholdFee;
import com.bluemoon.bluemoon.service.HouseholdFeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/household-fees")
public class HouseholdFeeController {

    private final HouseholdFeeService householdFeeService;

    public HouseholdFeeController(HouseholdFeeService householdFeeService) {
        this.householdFeeService = householdFeeService;
    }

    @PostMapping
    public ResponseEntity<HouseholdFee> create(@RequestBody HouseholdFee fee) {
        return ResponseEntity.ok(householdFeeService.create(fee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HouseholdFee> update(@PathVariable Long id,
                                               @RequestBody HouseholdFee fee) {
        return ResponseEntity.ok(householdFeeService.update(id, fee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        householdFeeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HouseholdFee> getById(@PathVariable Long id) {
        return ResponseEntity.ok(householdFeeService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<HouseholdFee>> getAll() {
        return ResponseEntity.ok(householdFeeService.getAll());
    }
}
