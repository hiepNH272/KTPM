package com.bluemoon.bluemoon.repository;

import com.bluemoon.bluemoon.entity.Household;
import com.bluemoon.bluemoon.entity.HouseholdFee;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HouseholdRepository extends JpaRepository<Household, Long> {

    Optional<Household> findByHouseholdCode(String householdCode);

    List<Household> findByApartmentNumber(String apartmentNumber);

    List<Household> findByActiveTrue();
    
   
}
