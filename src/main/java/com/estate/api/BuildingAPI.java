package com.estate.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.estate.model.response.BuildingSearchResponse;
import com.estate.service.BuildingService;

@RestController("/building")
public class BuildingAPI {
	
	@Autowired
	private BuildingService buildingService;
	
	@GetMapping
	public List<BuildingSearchResponse> findAll(@RequestParam Map<String, Object> requestParams, 
												@RequestParam(value = "types", required = false) List<String> types) {
		return buildingService.findAll(requestParams, types);
	}
}
