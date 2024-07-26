package com.dat.learninghub.config;

import java.util.Arrays;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class DataInitializer {
private final RoleService roleService;
	
	public DataInitializer(RoleService roleService) {
		this.roleService = roleService;
	}
	
	@PostConstruct
	public void init() throws Exception {
		roleService.initializeRoles(Arrays.asList("ADMIN", "INSTRUCTOR", "STUDENT"));
	}
}
