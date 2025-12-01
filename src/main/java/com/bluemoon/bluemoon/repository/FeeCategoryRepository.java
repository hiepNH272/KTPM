package com.bluemoon.bluemoon.repository;

import com.bluemoon.bluemoon.entity.FeeCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FeeCategoryRepository extends JpaRepository<FeeCategory, Long> {

    Optional<FeeCategory> findByCode(String code);

    List<FeeCategory> findByActiveTrue();
}
