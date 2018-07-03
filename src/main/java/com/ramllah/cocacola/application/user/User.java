package com.ramllah.cocacola.application.user;

import java.util.Arrays;
import javax.persistence.*;

@Entity
@Table(name="users")
public class User {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	private int role;
	private String address;
	private byte[] image;

	public User() {
	}

	public User(int id, String name, int role, String address, byte[] image) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.address = address;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", role=" + role + ", address=" + address + ", image="
				+ Arrays.toString(image) + "]";
	}

}
