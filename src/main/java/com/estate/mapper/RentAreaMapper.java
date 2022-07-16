package com.estate.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.estate.repository.entity.RentAreaEntity;

public class RentAreaMapper implements RowMapper<RentAreaEntity>{

	@Override
	public RentAreaEntity mapRow(ResultSet resultSet) {
		try {
			RentAreaEntity rentAreaEntity = new RentAreaEntity();
			rentAreaEntity.setId(resultSet.getLong("id"));
			rentAreaEntity.setBuildingId(resultSet.getLong("buildingid"));
			rentAreaEntity.setValue(resultSet.getInt("value"));
			return rentAreaEntity;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
