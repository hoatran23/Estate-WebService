package com.estate.repository;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;

import com.estate.repository.entity.BuildingEntity;

public interface BuildingRepository {
	List<BuildingEntity> findAll(@RequestParam Map<String, Object> requestParams, 
								 @RequestParam(value = "types", required = false) List<String> types);
}
