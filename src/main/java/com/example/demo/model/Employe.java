package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employe {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmploye;
	private String nom;
	private String prenom;
	private String mail;
	private String fonction;
	
	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Employe [idEmploye=" + idEmploye + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail
				+ ", fonction=" + fonction + "]";
	}


	public Employe( String nom, String prenom, String mail, String fonction) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.fonction = fonction;
	}

	public Long getIdEmploye() {
		return idEmploye;
	}


	
	public Employe(Long idEmploye, String nom, String prenom, String mail, String fonction) {
		super();
		this.idEmploye = idEmploye;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.fonction = fonction;
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	
	
	
	
}
