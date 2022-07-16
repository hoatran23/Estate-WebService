package com.estate.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estate.converter.BuildingConverter;
import com.estate.model.response.BuildingSearchResponse;
import com.estate.repository.BuildingRepository;
import com.estate.repository.entity.BuildingEntity;
import com.estate.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {
	
	@Autowired
	private BuildingRepository buildingRepository;
	
	@Autowired
	private BuildingConverter buildingConverter;
	
	@Override
	public List<BuildingSearchResponse> findAll(Map<String, Object> requestParams, List<String> types) {
		List<BuildingSearchResponse> results = new ArrayList<>();
		List<BuildingEntity> buildingEntities = buildingRepository.findAll(requestParams, types);
		for (BuildingEntity buildingEntity : buildingEntities) {
			BuildingSearchResponse buildingSearchResponse = buildingConverter.convertEntityToBuildingSearchResponse(buildingEntity);
			results.add(buildingSearchResponse);
		}
		return results;
	}
}
