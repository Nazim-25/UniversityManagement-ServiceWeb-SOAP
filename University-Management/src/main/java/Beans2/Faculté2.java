package Beans2;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class Faculté2 {
	
	private int Id_Faculté;
	private String NomFaculté;
	public Faculté2(int id_Faculté, String nomFaculté) {
		super();
		Id_Faculté = id_Faculté;
		NomFaculté = nomFaculté;
	}
	public Faculté2() {
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
	
}
