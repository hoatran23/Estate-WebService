package com.estate.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.estate.repository.entity.BuildingEntity;

public class BuildingMapper implements RowMapper<BuildingEntity> {
	@Override
	public BuildingEntity mapRow(ResultSet resultSet) {
		try {
			BuildingEntity buildingEntity = new BuildingEntity();
			buildingEntity.setId(resultSet.getLong("id"));
			buildingEntity.setName(resultSet.getString("name"));
			buildingEntity.setStreet(resultSet.getString("street"));
			buildingEntity.setWard(resultSet.getString("ward"));
			buildingEntity.setDistrictId(resultSet.getLong("districtid"));
			buildingEntity.setStructure(resultSet.getString("structure"));
			buildingEntity.setNumberOfBasement(resultSet.getInt("numberofbasement"));
			buildingEntity.setFloorArea(resultSet.getInt("floorarea"));
			buildingEntity.setDirection(resultSet.getString("direction"));
			buildingEntity.setLevel(resultSet.getString("level"));
			buildingEntity.setRentPrice(resultSet.getInt("rentprice"));
			buildingEntity.setRentPriceDescription(resultSet.getString("rentpricedescription"));
			buildingEntity.setServiceFee(resultSet.getString("servicefee"));
			buildingEntity.setCarFee(resultSet.getString("carfee"));
			buildingEntity.setMotorBikeFee(resultSet.getString("motorbikefee"));
			buildingEntity.setOvertimeFee(resultSet.getString("overtimefee"));
			buildingEntity.setWaterFee(resultSet.getString("waterfee"));
			buildingEntity.setElectricityFee(resultSet.getString("electricityfee"));
			buildingEntity.setDeposit(resultSet.getString("deposit"));
			buildingEntity.setPayment(resultSet.getString("payment"));
			buildingEntity.setRentTime(resultSet.getString("renttime"));
			buildingEntity.setDecorationTime(resultSet.getString("decorationtime"));
			buildingEntity.setBrokerageFee(resultSet.getBigDecimal("brokeragefee"));
			buildingEntity.setNote(resultSet.getString("note"));
			buildingEntity.setLinkOfBuilding(resultSet.getString("linkofbuilding"));
			buildingEntity.setMap(resultSet.getString("map"));
			buildingEntity.setImage(resultSet.getString("image"));
			buildingEntity.setCreatedDate(resultSet.getTimestamp("createddate"));
			buildingEntity.setCreatedBy(resultSet.getString("createdby"));
			if (resultSet.getTimestamp("modifieddate") != null) {
				buildingEntity.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			}
			if (resultSet.getString("modifiedby") != null) {
				buildingEntity.setModifiedBy(resultSet.getString("modifiedby"));
			}
			buildingEntity.setNameManager(resultSet.getString("namemanager"));
			buildingEntity.setPhoneManager(resultSet.getString("phonemanager"));
			return buildingEntity;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
