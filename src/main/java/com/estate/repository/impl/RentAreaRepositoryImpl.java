package com.estate.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.estate.mapper.RentAreaMapper;
import com.estate.repository.RentAreaRepository;
import com.estate.repository.entity.RentAreaEntity;

@Repository
public class RentAreaRepositoryImpl extends AbstractRepository implements RentAreaRepository{

	@Override
	public List<RentAreaEntity> findById(Long buildingId) {
		StringBuilder sql = new StringBuilder("SELECT * FROM rentarea ra WHERE ra.buildingid = " + buildingId);
		return query(sql.toString(), new RentAreaMapper());
	}
	
}
