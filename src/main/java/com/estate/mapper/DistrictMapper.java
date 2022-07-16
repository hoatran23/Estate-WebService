package com.estate.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.estate.repository.entity.DistrictEntity;

public class DistrictMapper implements RowMapper<DistrictEntity> {

	@Override
	public DistrictEntity mapRow(ResultSet resultSet) {
		try {
			DistrictEntity districtEntity = new DistrictEntity();
			districtEntity.setId(resultSet.getLong("id"));
			districtEntity.setCode(resultSet.getString("code"));
			districtEntity.setName(resultSet.getString("name"));
			return districtEntity;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
