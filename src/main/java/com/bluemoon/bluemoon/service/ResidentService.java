package com.bluemoon.bluemoon.service;

import com.bluemoon.bluemoon.entity.Resident;

import java.util.List;

public interface ResidentService {

    Resident create(Resident resident);

    Resident update(Long id, Resident resident);

    void delete(Long id);

    Resident getById(Long id);

    List<Resident> getAll();

    List<Resident> getByHousehold(Long householdId);

    List<Resident> getByResidenceStatus(String status);
}
