package com.citi.msstarchitecture.isiloans.dao;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class Elemento {

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@PostConstruct
	private void postConstruct() {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public String testQuery() {
		jdbcTemplate.queryForMap("select * from CAT_ELEMENTO");
		return "OK";
	}

}
