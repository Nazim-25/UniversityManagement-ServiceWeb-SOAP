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
public class Specialit� implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id_Specialit�;
	@Column(name = "nom_specialit�")
	private String NomSpecialit�;
	@Column(name = "abrv_specialit�")
	private String AbrvSpecialit�;
	@ManyToOne
	private D�partement d�partement;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "specialit�")
	private List<Niveau> niveau;

	public Specialit�() {
		super();
	}

	public Specialit�(int id_Specialit�) {
		super();
		Id_Specialit� = id_Specialit�;
	}

	public Specialit�(int id_Specialit�, String nomSpecialit�, String abrvSpecialit�, D�partement d�partement,
			List<Niveau> niveau) {
		super();
		Id_Specialit� = id_Specialit�;
		NomSpecialit� = nomSpecialit�;
		AbrvSpecialit� = abrvSpecialit�;
		this.d�partement = d�partement;
		this.niveau = niveau;
	}

	public int getId_Specialit�() {
		return Id_Specialit�;
	}

	public void setId_Specialit�(int id_Specialit�) {
		Id_Specialit� = id_Specialit�;
	}

	public String getNomSpecialit�() {
		return NomSpecialit�;
	}

	public void setNomSpecialit�(String nomSpecialit�) {
		NomSpecialit� = nomSpecialit�;
	}

	public String getAbrvSpecialit�() {
		return AbrvSpecialit�;
	}

	public void setAbrvSpecialit�(String abrvSpecialit�) {
		AbrvSpecialit� = abrvSpecialit�;
	}

	public D�partement getD�partement() {
		return d�partement;
	}

	public void setD�partement(D�partement d�partement) {
		this.d�partement = d�partement;
	}

	public List<Niveau> getNiveau() {
		return niveau;
	}

	public void setNiveau(List<Niveau> niveau) {
		this.niveau = niveau;
	}

}