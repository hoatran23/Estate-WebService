package com.estate.repository;

import com.estate.repository.entity.DistrictEntity;

public interface DistrictRepository {
	DistrictEntity findById(Long districtId);
}
