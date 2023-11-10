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
public class Niveau implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id_Niveau;
	@Column(name = "abrv_niveau")
	private String AbrvNiveau;

	@ManyToOne
	private Specialité specialité;

	public Niveau() {
		super();
	}

	public Niveau(int id_Niveau) {
		super();
		Id_Niveau = id_Niveau;
	}

	public Niveau(int id_Niveau, String abrvNiveau) {
		super();
		Id_Niveau = id_Niveau;
		AbrvNiveau = abrvNiveau;
	}

	public int getId_Niveau() {
		return Id_Niveau;
	}

	public void setId_Niveau(int id_Niveau) {
		Id_Niveau = id_Niveau;
	}

	public String getAbrvNiveau() {
		return AbrvNiveau;
	}

	public void setAbrvNiveau(String abrvNiveau) {
		AbrvNiveau = abrvNiveau;
	}

}
