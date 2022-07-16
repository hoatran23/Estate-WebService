package com.estate.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.estate.mapper.DistrictMapper;
import com.estate.repository.DistrictRepository;
import com.estate.repository.entity.DistrictEntity;

@Repository
public class DistrictRepositoryImpl extends AbstractRepository implements DistrictRepository {

	@Override
	public DistrictEntity findById(Long districtId) {
		StringBuilder sql = new StringBuilder("SELECT * FROM district d WHERE d.id = " + districtId);
		List<DistrictEntity> districtEntities = query(sql.toString(), new DistrictMapper());
		return districtEntities.isEmpty() ? null : districtEntities.get(0);
	}

}
