package com.dylan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DylanController {
	@Autowired
	JdbcTemplate jdbc;
	@GetMapping("/insert")
	public String index() {
		jdbc.execute("insert into user(name, email)values('gaurav',gaurav@gmail.com')");
		return "data inserted successfully";
	}
}
