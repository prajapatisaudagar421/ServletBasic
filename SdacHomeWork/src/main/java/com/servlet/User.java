package com.servlet;

public class User {
private String name;
private String email;
private String address;
private String password;
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public User(String name, String email, String address, String password) {
	super();
	this.name = name;
	this.email = email;
	this.address = address;
	this.password = password;
}
public String getName() {
	return name;
}
public String getEmail() {
	return email;
}
public String getAddress() {
	return address;
}
public String getPassword() {
	return password;
}
public void setName(String name) {
	this.name = name;
}
public void setEmail(String email) {
	this.email = email;
}
public void setAddress(String address) {
	this.address = address;
}
public void setPassword(String password) {
	this.password = password;
}

}
