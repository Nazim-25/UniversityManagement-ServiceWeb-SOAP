package Beans;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
@Entity
@Table(name= "Etudiant")
public class Etudiant implements Serializable{	
	@Id
	@Column(name ="matricule" ,nullable = false)
	private String matricule;
	private String nom;
	private String prenom;
	private String sexe;
	@Column(name="prenom_pere")
	private String prenomPere;
	@Column(name="nom_mere")
	private String nomMere;
	@Column(name="prenom_mere")
	private String prenomMere;
	@Temporal(TemporalType.DATE)
	private Date date_nais;
	@Column(name="date_der_inscription")
	@Temporal(TemporalType.DATE)
	private Date date_DerInscription;
	@ManyToOne
	private University university;
	@ManyToOne(targetEntity= D�partement.class)
	private D�partement d�partement;
	@ManyToOne
	private Formation formation;
	@ManyToOne
	private Niveau niveau;
	@ManyToOne
	private Specialit� specialit�;
	@ManyToOne(targetEntity= Facult�.class)
	private Facult� facult�;
	public Etudiant() {
		
	}


	public Etudiant(String matricule) {
		super();
		this.matricule = matricule;
	}


	public Etudiant(String matricule, String nom, String prenom, String sexe, String prenomPere, String nomMere,
			String prenomMere, Date date_nais, Date date_DerInscription, University university, D�partement d�partement,
			Formation formation, Niveau niveau, Specialit� specialit�, Facult� facult�) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.prenomPere = prenomPere;
		this.nomMere = nomMere;
		this.prenomMere = prenomMere;
		this.date_nais = date_nais;
		this.date_DerInscription = date_DerInscription;
		this.university = university;
		this.d�partement = d�partement;
		this.formation = formation;
		this.niveau = niveau;
		this.specialit� = specialit�;
		this.facult� = facult�;
	}


	public String getMatricule() {
		return matricule;
	}


	public void setMatricule(String matricule) {
		this.matricule = matricule;
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


	public String getSexe() {
		return sexe;
	}


	public void setSexe(String sexe) {
		this.sexe = sexe;
	}


	public String getPrenomPere() {
		return prenomPere;
	}


	public void setPrenomPere(String prenomPere) {
		this.prenomPere = prenomPere;
	}


	public String getNomMere() {
		return nomMere;
	}


	public void setNomMere(String nomMere) {
		this.nomMere = nomMere;
	}


	public String getPrenomMere() {
		return prenomMere;
	}


	public void setPrenomMere(String prenomMere) {
		this.prenomMere = prenomMere;
	}


	public Date getDate_nais() {
		return date_nais;
	}


	public void setDate_nais(Date date_nais) {
		this.date_nais = date_nais;
	}


	public Date getDate_DerInscription() {
		return date_DerInscription;
	}


	public void setDate_DerInscription(Date date_DerInscription) {
		this.date_DerInscription = date_DerInscription;
	}


	public University getUniversity() {
		return university;
	}


	public void setUniversity(University university) {
		this.university = university;
	}


	public D�partement getD�partement() {
		return d�partement;
	}


	public void setD�partement(D�partement d�partement) {
		this.d�partement = d�partement;
	}


	public Formation getFormation() {
		return formation;
	}


	public void setFormation(Formation formation) {
		this.formation = formation;
	}


	public Niveau getNiveau() {
		return niveau;
	}


	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}


	public Specialit� getSpecialit�() {
		return specialit�;
	}


	public void setSpecialit�(Specialit� specialit�) {
		this.specialit� = specialit�;
	}


	public Facult� getFacult�() {
		return facult�;
	}


	public void setFacult�(Facult� facult�) {
		this.facult� = facult�;
	}



	
}
