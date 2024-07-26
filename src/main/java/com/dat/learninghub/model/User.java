package com.dat.learninghub.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String division;
	private String staff_id;
	private String name;
	private String door_log_no;
	private String dept;
	private String team;
	private String email;
	private String password;
	private boolean enabled;
	
	@PrePersist
	protected void onCreate() {
		this.enabled = true;
	}
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> user_roles = new HashSet<>();

	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getDivision() {
		return division;
	}



	public void setDivision(String division) {
		this.division = division;
	}



	public String getStaff_id() {
		return staff_id;
	}



	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDoor_log_no() {
		return door_log_no;
	}



	public void setDoor_log_no(String door_log_no) {
		this.door_log_no = door_log_no;
	}



	public String getDept() {
		return dept;
	}



	public void setDept(String dept) {
		this.dept = dept;
	}



	public String getTeam() {
		return team;
	}



	public void setTeam(String team) {
		this.team = team;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public boolean isEnabled() {
		return enabled;
	}



	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}



	public Set<Role> getUser_roles() {
		return user_roles;
	}



	public void setUser_roles(Set<Role> user_roles) {
		this.user_roles = user_roles;
	}



	public User() {
		
	}

	

}
