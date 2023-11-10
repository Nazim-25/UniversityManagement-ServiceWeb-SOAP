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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;



@Entity
public class Faculté implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id_Faculté;
	@Column(name="nom_faculté")
	private String NomFaculté;
	@ManyToOne 
	private University university;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="faculté",fetch = FetchType.EAGER)
	private List<Département> département;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="faculté")
	private List<Faculté> faculté;

	public Faculté(int id_Faculté, String nomFaculté, University university, List<Département> département,
			List<Faculté> faculties) {
		super();
		Id_Faculté = id_Faculté;
		NomFaculté = nomFaculté;
		this.university = university;
		this.département = département;
		this.faculté = faculties;
	}
	

	


	public List<Faculté> getFaculties() {
		return faculté;
	}


	public void setFaculties(List<Faculté> faculties) {
		this.faculté = faculties;
	}


	public Faculté(int id_Faculté) {
		super();
		Id_Faculté = id_Faculté;
	}

	public Faculté() {
		super();
	}

	public int getId_Faculté() {
		return Id_Faculté;
	}

	public void setId_Faculté(int id_Faculté) {
		Id_Faculté = id_Faculté;
	}

	public String getNomFaculté() {
		return NomFaculté;
	}

	public void setNomFaculté(String nomFaculté) {
		NomFaculté = nomFaculté;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public List<Département> getDépartement() {
		return département;
	}

	public void setDépartement(List<Département> département) {
		this.département = département;
	}

	
	


}