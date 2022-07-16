package com.estate.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.estate.constant.SystemConstant;
import com.estate.mapper.BuildingMapper;
import com.estate.repository.BuildingRepository;
import com.estate.repository.entity.BuildingEntity;
import com.estate.utils.MapUtils;
import com.estate.utils.NumberUtils;


@Repository
public class BuildingRepositoryImpl extends AbstractRepository implements BuildingRepository{

	@Override
	public List<BuildingEntity> findAll(Map<String, Object> requestParams, List<String> types) {
		StringBuilder sql = new StringBuilder("SELECT * FROM building b");
		sql = buildSqlJoining(requestParams, types, sql);
		sql.append("\n" + SystemConstant.ONE_EQUAL_ONE);
		sql = buildSqlCommon(requestParams, sql);
		sql = buildSqlSpecial(requestParams, types, sql);
		sql.append("\nGROUP BY b.id");
		return query(sql.toString(), new BuildingMapper());
	}

	private StringBuilder buildSqlJoining(Map<String, Object> requestParams, List<String> types, StringBuilder sql) {
		sql.append("\nJOIN district d ON b.districtId = d.id");
		
		Long staffId = MapUtils.getObject(requestParams, "staffid", Long.class);
		Integer rentareaFrom = MapUtils.getObject(requestParams , "rentareafrom", Integer.class);
		Integer rentareaTo = MapUtils.getObject(requestParams , "rentareato", Integer.class);
		
		if (staffId != null) {
			sql.append("\nJOIN assignmentbuilding ab ON b.id = ab.buildingid");
			sql.append("\nJOIN user u ON ab.staffid = u.id");
		}
		
		if (rentareaFrom != null || rentareaTo != null) {
			sql.append("\nJOIN rentarea ra ON b.id = ra.buildingid");
		}
		
		if (types != null) {
			sql.append("\nJOIN buildingrenttype br ON br.buildingid = b.id");
			sql.append("\nJOIN renttype rt ON rt.id = br.renttypeid");
		}
		return sql;
	}
	
	private StringBuilder buildSqlCommon(Map<String, Object> requestParams, StringBuilder sql) {
		for (Map.Entry<String, Object> item : requestParams.entrySet()) {
			if (!item.getKey().equals("staffid") && !item.getKey().equals("districtid") && !item.getKey().equals("types") &&
					!item.getKey().startsWith("rentarea") && !item.getKey().startsWith("rentprice")) {
				String value = item.getValue().toString();
				if (NumberUtils.isInteger(value) && !item.getKey().equals("ward") && !item.getKey().equals("phonemanager")) {
					sql.append("\nAND b." + item.getKey().toLowerCase() + " = " + Integer.parseInt(value));
				} else {
					sql.append("\nAND b." + item.getKey().toLowerCase() + " LIKE '%" + value + "%'");
				}
			}
		}
		return sql;
	}
	
	private StringBuilder buildSqlSpecial(Map<String, Object> requestParams, List<String> types, StringBuilder sql) {
		Long districtId =  MapUtils.getObject(requestParams, "districtid", Long.class);
		Long staffId =  MapUtils.getObject(requestParams, "staffid", Long.class);
		Integer rentareaFrom =  MapUtils.getObject(requestParams, "rentareafrom", Integer.class);
		Integer rentareaTo =  MapUtils.getObject(requestParams, "rentareato", Integer.class);
		Integer rentpriceFrom =  MapUtils.getObject(requestParams, "rentpricefrom", Integer.class);
		Integer rentpriceTo =  MapUtils.getObject(requestParams, "rentpriceto", Integer.class);
		
		if (districtId != null) {
			sql.append("\nAND d.id = " + districtId);
		}
		
		if (staffId != null) {
			sql.append("\nAND u.id = " + staffId);
		}
		
		/* Cach 1: Cách sử dụng EXITST không cần JOIN
		if (rentareaFrom != null || rentareaTo != null) {
			sql.append("\nAND EXITST (SELECT ra.value FROM rentarea ra WHERE ON b.id = ra.buildingid");
			if (rentareaFrom != null) {
				sql.append("\nAND ra.value >= " + rentareaFrom);
			}
			if (rentareaTo != null) {
				sql.append("\nAND ra.value <= " + rentareaTo);
			}	
		}
		*/
		// Cach 2
		if (rentareaFrom != null) {
			sql.append("\nAND ra.value >= " + rentareaFrom);
		}
		
		if (rentareaTo != null) {
			sql.append("\nAND ra.value <= " + rentareaTo);
		}
		
		if (rentpriceFrom != null) {
			sql.append("\nAND b.rentprice >= " + rentpriceFrom);
		}
		
		if (rentpriceTo != null) {
			sql.append("\nAND b.rentprice <= " + rentpriceTo);
		}
		
		if (types != null) {
			/*
			 * Cach 1: Khong can dung for
			sql.append("\nAND rt.code IN (");
			String result = String.join("'" + ", " + "'", types);
			sql.append("'" + result + "')");
			*/
			
			/*
			 * Cach 2: Dung for voi query or
			List<String> result = new ArrayList<>();
			sql.append("\nAND (");
			for (String type: types) {
				result.add("rt.code = '" + type + "'");
			}
			String sqlJoin = String.join(" OR ", result);
			sql.append(sqlJoin + ")");
			*/
			
			/* Cach 3: Dung for voi query IN
			List<String> result = new ArrayList<>();
			sql.append("\nAND rt.code IN(");
			for (String type: types) {
				result.add("'" + type + "'");
			}
			String sqlJoin = String.join(", ", result);
			sql.append(sqlJoin + ")");
			*/
		}
		return sql; 
	}
}
