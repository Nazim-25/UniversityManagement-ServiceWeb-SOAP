package Beans2;

public class Etudiant2 {
	private String matricule;
	private String nom;
	private String prenom;
	private Facult�2 facult�;
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Facult�2 getFacult�() {
		return facult�;
	}
	public void setFacult�(Facult�2 facult�) {
		this.facult� = facult�;
	}
	public Etudiant2(String matricule, String nom, String prenom, Facult�2 facult�) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.facult� = facult�;
	}
	public Etudiant2() {
		super();
	}
	
	
}
