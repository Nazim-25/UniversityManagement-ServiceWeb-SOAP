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



@Entity
public class Formation implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id_Formation;
	@Column(name="nom_formation")
	private String NomFormation;
	@Column(name="abrv_formation")
	private String AbrvFormation;
	@ManyToOne (targetEntity= Facult�.class)
	private Facult� facult�;
	
	
	public Formation() {
		super();
	}


	public Formation(int id_Formation, String nomFormation, String abrvFormation, Facult� faculte) {
		super();
		Id_Formation = id_Formation;
		NomFormation = nomFormation;
		AbrvFormation = abrvFormation;
		this.facult� = faculte;
	}


	public int getId_Formation() {
		return Id_Formation;
	}


	public void setId_Formation(int id_Formation) {
		Id_Formation = id_Formation;
	}


	public String getNomFormation() {
		return NomFormation;
	}


	public void setNomFormation(String nomFormation) {
		NomFormation = nomFormation;
	}


	public String getAbrvFormation() {
		return AbrvFormation;
	}


	public void setAbrvFormation(String abrvFormation) {
		AbrvFormation = abrvFormation;
	}


	public Facult� getFacult�() {
		return facult�;
	}


	public void setFacult�(Facult� faculte) {
		this.facult� = faculte;
	}


	public Formation(int id_Formation) {
		super();
		Id_Formation = id_Formation;
	}
	


}