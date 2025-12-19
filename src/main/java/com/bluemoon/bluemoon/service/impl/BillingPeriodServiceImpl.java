package com.bluemoon.bluemoon.service.impl;

import com.bluemoon.bluemoon.entity.BillingPeriod;
import com.bluemoon.bluemoon.exception.ResourceNotFoundException;
import com.bluemoon.bluemoon.repository.BillingPeriodRepository;
import com.bluemoon.bluemoon.service.BillingPeriodService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BillingPeriodServiceImpl implements BillingPeriodService {

    private final BillingPeriodRepository billingPeriodRepository;

    public BillingPeriodServiceImpl(BillingPeriodRepository billingPeriodRepository) {
        this.billingPeriodRepository = billingPeriodRepository;
    }

    @Override
    public BillingPeriod create(BillingPeriod period) {
        return billingPeriodRepository.save(period);
    }

    @Override
    public BillingPeriod update(Long id, BillingPeriod period) {
        BillingPeriod existing = billingPeriodRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BillingPeriod not found with id " + id));

        existing.setYear(period.getYear());
        existing.setMonth(period.getMonth());
        existing.setStartDate(period.getStartDate());
        existing.setEndDate(period.getEndDate());
        existing.setClosed(period.getClosed());

        return billingPeriodRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
    	if(!billingPeriodRepository.existsById(id)) {
    		throw new ResourceNotFoundException("BillingPeriod not found with id " + id);
    	}
        billingPeriodRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public BillingPeriod getById(Long id) {
        return billingPeriodRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BillingPeriod not found with id " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<BillingPeriod> getAll() {
        return billingPeriodRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public BillingPeriod getByYearMonth(Integer year, Integer month) {
        return billingPeriodRepository.findByYearAndMonth(year, month)
                .orElseThrow(() -> new ResourceNotFoundException("BillingPeriod not found for " + year + "-" + month));
    }
}
