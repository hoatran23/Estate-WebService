package com.estate.repository;

import java.util.List;

import com.estate.repository.entity.RentAreaEntity;

public interface RentAreaRepository {
	List<RentAreaEntity> findById(Long buildingId);
}
