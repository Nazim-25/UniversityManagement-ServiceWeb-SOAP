package Beans2;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class Facult�2 {
	
	private int Id_Facult�;
	private String NomFacult�;
	public Facult�2(int id_Facult�, String nomFacult�) {
		super();
		Id_Facult� = id_Facult�;
		NomFacult� = nomFacult�;
	}
	public Facult�2() {
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
	
}
