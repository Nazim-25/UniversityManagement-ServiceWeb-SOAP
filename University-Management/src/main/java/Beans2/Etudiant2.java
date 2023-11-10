package Beans2;

public class Etudiant2 {
	private String matricule;
	private String nom;
	private String prenom;
	private Faculté2 faculté;
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
	public Faculté2 getFaculté() {
		return faculté;
	}
	public void setFaculté(Faculté2 faculté) {
		this.faculté = faculté;
	}
	public Etudiant2(String matricule, String nom, String prenom, Faculté2 faculté) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.faculté = faculté;
	}
	public Etudiant2() {
		super();
	}
	
	
}
