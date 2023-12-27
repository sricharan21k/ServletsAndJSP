package com.servletlogin;

public class Person {
	
	private String username;
	private int age;
	private String city;
	
	public Person(String username,int age, String city) {
		this.username = username;
		this.age = age;
		this.city = city;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [username=" + username + ", age=" + age + ", city=" + city + "]";
	}
	
	

}
