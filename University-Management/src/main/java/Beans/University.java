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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class University implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id_University;
	@Column(name = "nom_university")
	private String NomUniversity;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "university")
	private List<Faculté> faculté;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "university")
	private List<Utilisateur> Users;

	public University(int id_University, String nomUniversity) {
		super();
		Id_University = id_University;
		NomUniversity = nomUniversity;
	}

	public University() {
		super();
	}

	public University(int id_University) {
		super();
		Id_University = id_University;
	}

	public int getId_University() {
		return Id_University;
	}

	public void setId_University(int id_University) {
		Id_University = id_University;
	}

	public String getNomUniversity() {
		return NomUniversity;
	}

	public void setNomUniversity(String nomUniversity) {
		NomUniversity = nomUniversity;
	}

}
