package com.bluemoon.bluemoon.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;




@Entity
@Table(name = "fee_category")

public class FeeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String code;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 255)
    private String description;

    @Column(name = "unit", length = 50)
    private String unit;

    @Column(name = "default_amount", precision = 15, scale = 2)
    private BigDecimal defaultAmount;

    @Column(name = "fixed_monthly")
    private Boolean fixedMonthly = true;

    @Column(name = "active")
    private Boolean active = true;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public BigDecimal getDefaultAmount() {
		return defaultAmount;
	}

	public void setDefaultAmount(BigDecimal defaultAmount) {
		this.defaultAmount = defaultAmount;
	}

	public Boolean getFixedMonthly() {
		return fixedMonthly;
	}

	public void setFixedMonthly(Boolean fixedMonthly) {
		this.fixedMonthly = fixedMonthly;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
}
