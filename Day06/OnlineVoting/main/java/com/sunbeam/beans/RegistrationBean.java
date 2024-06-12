package com.sunbeam.beans;

import java.sql.Date;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class RegistrationBean {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String birth;
	private int count;
	private User user;

	int status = 0;
	private String role = "voter";

    
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public RegistrationBean() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public void register() {
		Date dob = Date.valueOf(this.birth);
		User u1 = new User(firstName, lastName, email, password, dob, status, role);
		
		try (UserDao userDao = new UserDaoImpl()) {
			count = userDao.save(u1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
