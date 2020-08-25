package com.example.demo.ui.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "users")
public class UserEntity implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String agent_id;

	@Column(nullable = false)
	private String encryptedPassword;
	
	
	@OneToMany(mappedBy = "userDetails", cascade = CascadeType.ALL)
	private List<Todo> addresses;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getAgent_id() {
		return agent_id;
	}


	public void setAgent_id(String agent_id) {
		this.agent_id = agent_id;
	}


	public String getEncryptedPassword() {
		return encryptedPassword;
	}


	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}


	public List<Todo> getAddresses() {
		return addresses;
	}


	public void setAddresses(List<Todo> addresses) {
		this.addresses = addresses;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
