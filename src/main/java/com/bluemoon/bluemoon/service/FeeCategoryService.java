package com.bluemoon.bluemoon.service;

import com.bluemoon.bluemoon.entity.FeeCategory;

import java.util.List;

public interface FeeCategoryService {

    FeeCategory create(FeeCategory feeCategory);

    FeeCategory update(Long id, FeeCategory feeCategory);

    void delete(Long id);

    FeeCategory getById(Long id);

    List<FeeCategory> getAll();

    List<FeeCategory> getActive();
}
