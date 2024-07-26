package com.dat.learninghub.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dat.learninghub.model.Role;

public interface RoleRepository extends JpaRepository<Role,Integer>{
	@Query("SELECT r from Role r LEFT JOIN FETCH r.users WHERE r.role = :role")
	Optional<Role> findByName(@Param("role")String role);
}