package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class User {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nom;
	private String prenom;
	
	//relation ManutoMany
	
	@ManyToMany
	@JoinTable(name="user_roles",joinColumns = {@JoinColumn(name ="user")},	inverseJoinColumns = {@JoinColumn(name="role")})
	private List<Role> roles;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String nom, String prenom, List<Role> roles) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.roles = roles;
	}

	public User(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
}
