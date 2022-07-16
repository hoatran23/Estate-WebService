package com.estate.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;

import com.estate.model.response.BuildingSearchResponse;

public interface BuildingService {
	List<BuildingSearchResponse> findAll(@RequestParam Map<String, Object> requestParams, 
										 @RequestParam(value = "types", required = false) List<String> types);
}
