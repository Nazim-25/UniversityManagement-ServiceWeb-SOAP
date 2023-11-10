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
public class Facult� implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id_Facult�;
	@Column(name="nom_facult�")
	private String NomFacult�;
	@ManyToOne 
	private University university;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="facult�",fetch = FetchType.EAGER)
	private List<D�partement> d�partement;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="facult�")
	private List<Facult�> facult�;

	public Facult�(int id_Facult�, String nomFacult�, University university, List<D�partement> d�partement,
			List<Facult�> faculties) {
		super();
		Id_Facult� = id_Facult�;
		NomFacult� = nomFacult�;
		this.university = university;
		this.d�partement = d�partement;
		this.facult� = faculties;
	}
	

	


	public List<Facult�> getFaculties() {
		return facult�;
	}


	public void setFaculties(List<Facult�> faculties) {
		this.facult� = faculties;
	}


	public Facult�(int id_Facult�) {
		super();
		Id_Facult� = id_Facult�;
	}

	public Facult�() {
		super();
	}

	public int getId_Facult�() {
		return Id_Facult�;
	}

	public void setId_Facult�(int id_Facult�) {
		Id_Facult� = id_Facult�;
	}

	public String getNomFacult�() {
		return NomFacult�;
	}

	public void setNomFacult�(String nomFacult�) {
		NomFacult� = nomFacult�;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public List<D�partement> getD�partement() {
		return d�partement;
	}

	public void setD�partement(List<D�partement> d�partement) {
		this.d�partement = d�partement;
	}

	
	


}