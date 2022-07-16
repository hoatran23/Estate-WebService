package com.estate.converter;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.estate.model.response.BuildingSearchResponse;
import com.estate.repository.DistrictRepository;
import com.estate.repository.RentAreaRepository;
import com.estate.repository.entity.BuildingEntity;
import com.estate.repository.entity.DistrictEntity;
import com.estate.repository.entity.RentAreaEntity;

@Component
public class BuildingConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private DistrictRepository districtRepository;
	
	@Autowired
	private RentAreaRepository rentAreaRepository;
	
	public BuildingEntity convertBuildingSearchResponseToEntity(BuildingSearchResponse buildingSearchResponse) {
		BuildingEntity buildingEntity = new BuildingEntity();
		buildingEntity = modelMapper.map(buildingSearchResponse, BuildingEntity.class);
		return buildingEntity;
	}
	
	public BuildingSearchResponse convertEntityToBuildingSearchResponse (BuildingEntity buildingEntity) {
		BuildingSearchResponse buildingSearchResponse = modelMapper.map(buildingEntity, BuildingSearchResponse.class);
		DistrictEntity districtEntity = districtRepository.findById(buildingEntity.getDistrictId());
		buildingSearchResponse.setAddress(buildingEntity.getStreet() + " - " + buildingEntity.getWard() + " - " + districtEntity.getName());
		List<RentAreaEntity> rentAreaEntities = rentAreaRepository.findById(buildingEntity.getId()); 
		List<String> rentArea = new ArrayList<>();
		for (RentAreaEntity rentAreaEntity : rentAreaEntities) {
			rentArea.add(rentAreaEntity.getValue().toString());
		}
		buildingSearchResponse.setRentArea(String.join(", ", rentArea));
		return buildingSearchResponse;
	}
}
