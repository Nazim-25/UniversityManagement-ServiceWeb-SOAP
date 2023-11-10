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
public class Specialité implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id_Specialité;
	@Column(name = "nom_specialité")
	private String NomSpecialité;
	@Column(name = "abrv_specialité")
	private String AbrvSpecialité;
	@ManyToOne
	private Département département;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "specialité")
	private List<Niveau> niveau;

	public Specialité() {
		super();
	}

	public Specialité(int id_Specialité) {
		super();
		Id_Specialité = id_Specialité;
	}

	public Specialité(int id_Specialité, String nomSpecialité, String abrvSpecialité, Département département,
			List<Niveau> niveau) {
		super();
		Id_Specialité = id_Specialité;
		NomSpecialité = nomSpecialité;
		AbrvSpecialité = abrvSpecialité;
		this.département = département;
		this.niveau = niveau;
	}

	public int getId_Specialité() {
		return Id_Specialité;
	}

	public void setId_Specialité(int id_Specialité) {
		Id_Specialité = id_Specialité;
	}

	public String getNomSpecialité() {
		return NomSpecialité;
	}

	public void setNomSpecialité(String nomSpecialité) {
		NomSpecialité = nomSpecialité;
	}

	public String getAbrvSpecialité() {
		return AbrvSpecialité;
	}

	public void setAbrvSpecialité(String abrvSpecialité) {
		AbrvSpecialité = abrvSpecialité;
	}

	public Département getDépartement() {
		return département;
	}

	public void setDépartement(Département département) {
		this.département = département;
	}

	public List<Niveau> getNiveau() {
		return niveau;
	}

	public void setNiveau(List<Niveau> niveau) {
		this.niveau = niveau;
	}

}