package com.bluemoon.bluemoon.service;

import com.bluemoon.bluemoon.entity.BillingPeriod;

import java.util.List;

public interface BillingPeriodService {

    BillingPeriod create(BillingPeriod period);

    BillingPeriod update(Long id, BillingPeriod period);

    void delete(Long id);

    BillingPeriod getById(Long id);

    List<BillingPeriod> getAll();

    BillingPeriod getByYearMonth(Integer year, Integer month);
}
