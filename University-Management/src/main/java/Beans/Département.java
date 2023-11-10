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
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@Table(name= "département")
public class Département implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id_Département;
	@Column(name="nom_département")
	private String NomDépartement;
	
	@Column(name="abrv_département")
	private String AbrvDépartement;
	@ManyToOne
	private Faculté faculté;
	
	

	@OneToMany(cascade=CascadeType.ALL, mappedBy="département",fetch = FetchType.EAGER)
	private List<Specialité> specialité;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="département")
	private List<Etudiant> etudiants;

	
	public Département(int id_Département) {
		super();
		Id_Département = id_Département;
	}

	public Département() {
		super();
	}

	public Département(int id_Département, String nomDépartement, String abrvDépartement, Faculté faculté,
			List<Specialité> specialité, List<Etudiant> etudiants) {
		super();
		Id_Département = id_Département;
		NomDépartement = nomDépartement;
		AbrvDépartement = abrvDépartement;
		this.faculté = faculté;
		this.specialité = specialité;
		this.etudiants = etudiants;
	}

	public int getId_Département() {
		return Id_Département;
	}

	public void setId_Département(int id_Département) {
		Id_Département = id_Département;
	}

	public String getNomDépartement() {
		return NomDépartement;
	}

	public void setNomDépartement(String nomDépartement) {
		NomDépartement = nomDépartement;
	}

	public String getAbrvDépartement() {
		return AbrvDépartement;
	}

	public void setAbrvDépartement(String abrvDépartement) {
		AbrvDépartement = abrvDépartement;
	}

	public Faculté getFaculté() {
		return faculté;
	}

	public void setFaculté(Faculté faculté) {
		this.faculté = faculté;
	}

	public List<Specialité> getSpecialité() {
		return specialité;
	}

	public void setSpecialité(List<Specialité> specialité) {
		this.specialité = specialité;
	}

	public List<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}