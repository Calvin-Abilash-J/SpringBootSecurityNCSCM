package com.SecurityLoginNCSCM.Security.Login.SecurityModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "signin_entity")
public class SigninEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String hashedpassword;
	private String salt;
	private String email;
	public SigninEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SigninEntity(Long id, String username, String hashedpassword, String salt, String email) {
		super();
		this.id = id;
		this.username = username;
		this.hashedpassword = hashedpassword;
		this.salt = salt;
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getHashedpassword() {
		return hashedpassword;
	}
	public void setHashedpassword(String hashedpassword) {
		this.hashedpassword = hashedpassword;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
