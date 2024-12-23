package com.sunbeam.beans;

import javax.servlet.ServletException;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class LoginBean {
	private String email;
	private String password;
	private User user;

	public LoginBean() {

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void authenticate() {

		try (UserDao userDao = new UserDaoImpl()) {
			User u = userDao.findByEmail(email);
			if (u != null && u.getPassword().equals(password))
			   this.user = u;
			else
				this.user = null;   
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}
