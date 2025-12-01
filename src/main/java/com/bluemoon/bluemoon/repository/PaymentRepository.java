package com.bluemoon.bluemoon.repository;

import com.bluemoon.bluemoon.entity.Payment;
import com.bluemoon.bluemoon.entity.HouseholdFee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findByHouseholdFee(HouseholdFee householdFee);
}
