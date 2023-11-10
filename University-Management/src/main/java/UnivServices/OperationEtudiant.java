package UnivServices;

import java.sql.Date;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import Beans.Etudiant;
import Beans.Niveau;
import Beans.Specialité;
import Beans.University;
import Beans.Utilisateur;
import Beans2.Etudiant2;
import Beans2.Faculté2;

//This class serves as a web service handling student verification operations
public class OperationEtudiant {
	
	// Method to retrieve a student by matricule
	public Etudiant2 rechercheByMatricule(String Matricule) {

		Connexion co = new Connexion();
		try {
			co.connect();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Etudiant2 a = new Etudiant2();
		try {
			Statement stmt = co.con.createStatement();

			ResultSet rs = stmt.executeQuery("select * from Etudiant where matricule = '" + Matricule + "';");

			if (rs.next()) {
				String matricule = rs.getString("matricule");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");

				int id_fac = rs.getInt("faculté_id_faculté");
				a.setMatricule(matricule);
				a.setNom(nom);
				a.setPrenom(prenom);

				a.setFaculté(GetFaculté(id_fac));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return a;
	}
	
	// Method to verify the existence of a student by matricule
	public boolean verifierEtudiant(String Matricule) {
		Connexion co = new Connexion();
		try {
			co.connect();
		} catch (ClassNotFoundException e1) {

			e1.printStackTrace();
		}
		Statement stmt;
		try {
			stmt = co.con.createStatement();

			ResultSet rs = stmt.executeQuery("select matricule from Etudiant;");
			while (rs.next()) {
				String matricule = rs.getString("matricule");

				if (Matricule.equals(matricule)) {
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	 // Method to search students by name
	public List<Etudiant2> rechercheByName(String name) {

		Connexion co = new Connexion();
		try {
			co.connect();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<Etudiant2> Etudiants = new ArrayList<Etudiant2>();

		try {
			Statement stmt = co.con.createStatement();

			ResultSet rs = stmt.executeQuery("select * from Etudiant where nom = '" + name + "';");

			while (rs.next()) {
				Etudiant2 a = new Etudiant2();
				String matricule = rs.getString("matricule");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");

				int id_fac = rs.getInt("faculté_id_faculté");

				a.setMatricule(matricule);
				a.setNom(nom);
				a.setPrenom(prenom);
				a.setFaculté(GetFaculté(id_fac));
				Etudiants.add(a);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return Etudiants;
	}
	 // Method to search students by name and surname
	public List<Etudiant2> rechercheByNomPrenom(String Nom, String Prenom) {

		Connexion co = new Connexion();
		try {
			co.connect();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<Etudiant2> Etudiants = new ArrayList<Etudiant2>();

		try {
			Statement stmt = co.con.createStatement();

			ResultSet rs = stmt
					.executeQuery("select * from Etudiant where nom = '" + Nom + "' and prenom ='" + Prenom + "';");

			while (rs.next()) {
				Etudiant2 a = new Etudiant2();
				String matricule = rs.getString("matricule");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");

				int id_fac = rs.getInt("faculté_id_faculté");

				a.setMatricule(matricule);
				a.setNom(nom);
				a.setPrenom(prenom);
				a.setFaculté(GetFaculté(id_fac));
				Etudiants.add(a);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return Etudiants;
	}
	// Method to retrieve faculty information by ID
	public Faculté2 GetFaculté(int id_faculté) {

		Connexion co = new Connexion();
		try {
			co.connect();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Faculté2 fac = new Faculté2();
		try {
			Statement stmt = co.con.createStatement();

			ResultSet rs = stmt.executeQuery("select * from Faculté where id_faculté = '" + id_faculté + "';");

			if (rs.next()) {
				int id_faculte = rs.getInt("id_faculté");
				String nom_faculté = rs.getString("nom_faculté");
				fac.setId_Faculté(id_faculte);
				fac.setNomFaculté(nom_faculté);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return fac;
	}
	// Method to register a new student
	public boolean Inscription(Etudiant etudiant) {

		Connexion co = new Connexion();
		try {
			co.connect();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		boolean ajouter = true;

		Statement stmt;
		try {
			stmt = co.con.createStatement();
			if (verifierEtudiant(etudiant.getMatricule()) != true) {
				java.sql.Date dateN = new java.sql.Date(etudiant.getDate_nais().getTime());
				java.sql.Date dateins = new java.sql.Date(etudiant.getDate_DerInscription().getTime());

				stmt.executeUpdate(
						"insert into Etudiant(matricule,nom,prenom,sexe,date_der_inscription,prenom_pere,nom_mere"
								+ ",prenom_mere,faculté_id_faculté,département_id_département,formation_id_formation,niveau_id_niveau,"
								+ "specialité_id_specialité,university_id_university,date_nais) values('"
								+ etudiant.getMatricule() + "','" + etudiant.getNom() + "'," + "'"
								+ etudiant.getPrenom() + "','" + etudiant.getSexe() + "','" + dateins + "','"
								+ etudiant.getPrenomPere() + "','" + etudiant.getNomMere() + "'," + "'"
								+ etudiant.getPrenomMere() + "','" + etudiant.getFaculté().getId_Faculté() + "','"
								+ etudiant.getDépartement().getId_Département() + "'," + "'"
								+ etudiant.getFormation().getId_Formation() + "','"
								+ etudiant.getNiveau().getId_Niveau() + "'," + "'"
								+ etudiant.getSpecialité().getId_Specialité() + "','"
								+ etudiant.getDépartement().getId_Département() + "','" + dateN + "');");

			} else {
				ajouter = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ajouter;
	}
	// Method for guard authentication
	public boolean AuthentificationGarde(String email, String password) {
		Connexion co = new Connexion();
		try {
			co.connect();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Statement stmt;
		String type = "Garde";
		try {
			stmt = co.con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Utilisateur where email='" + email + "' and password='"
					+ password + "' and type='" + type + "' ;");
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

}
