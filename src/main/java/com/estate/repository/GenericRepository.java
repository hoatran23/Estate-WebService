package com.estate.repository;

import java.util.List;

import com.estate.mapper.RowMapper;

public interface GenericRepository {
	<T> List<T> query(String sql, RowMapper<T> rowMapper);
}
