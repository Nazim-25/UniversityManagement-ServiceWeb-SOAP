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
@Table(name= "d�partement")
public class D�partement implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id_D�partement;
	@Column(name="nom_d�partement")
	private String NomD�partement;
	
	@Column(name="abrv_d�partement")
	private String AbrvD�partement;
	@ManyToOne
	private Facult� facult�;
	
	

	@OneToMany(cascade=CascadeType.ALL, mappedBy="d�partement",fetch = FetchType.EAGER)
	private List<Specialit�> specialit�;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="d�partement")
	private List<Etudiant> etudiants;

	
	public D�partement(int id_D�partement) {
		super();
		Id_D�partement = id_D�partement;
	}

	public D�partement() {
		super();
	}

	public D�partement(int id_D�partement, String nomD�partement, String abrvD�partement, Facult� facult�,
			List<Specialit�> specialit�, List<Etudiant> etudiants) {
		super();
		Id_D�partement = id_D�partement;
		NomD�partement = nomD�partement;
		AbrvD�partement = abrvD�partement;
		this.facult� = facult�;
		this.specialit� = specialit�;
		this.etudiants = etudiants;
	}

	public int getId_D�partement() {
		return Id_D�partement;
	}

	public void setId_D�partement(int id_D�partement) {
		Id_D�partement = id_D�partement;
	}

	public String getNomD�partement() {
		return NomD�partement;
	}

	public void setNomD�partement(String nomD�partement) {
		NomD�partement = nomD�partement;
	}

	public String getAbrvD�partement() {
		return AbrvD�partement;
	}

	public void setAbrvD�partement(String abrvD�partement) {
		AbrvD�partement = abrvD�partement;
	}

	public Facult� getFacult�() {
		return facult�;
	}

	public void setFacult�(Facult� facult�) {
		this.facult� = facult�;
	}

	public List<Specialit�> getSpecialit�() {
		return specialit�;
	}

	public void setSpecialit�(List<Specialit�> specialit�) {
		this.specialit� = specialit�;
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