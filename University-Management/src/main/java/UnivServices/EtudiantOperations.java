package UnivServices;

import java.sql.Date;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import Beans.Département;
import Beans.Etudiant;
import Beans.Faculté;
import Beans.Formation;
import Beans.Garde;
import Beans.Niveau;
import Beans.Specialité;
import Beans.University;
import Beans.Utilisateur;
//This class manages various university operations such as student information retrieval, registration, and more
public class EtudiantOperations {
	// Retrieves a list of students by name
	public List<Etudiant> rechercheByNom(String name) {
		List<Etudiant> result = new ArrayList<Etudiant>();

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String query = "select e from Etudiant e where e.nom=:nom ";
		result = session.createQuery(query, Etudiant.class).setParameter("nom", name).list();
		session.getTransaction().commit();
		session.close();
		return result;
	}
	// Retrieves a student by matricule
	public Etudiant rechercheByMatricule(String Matricule) {
		Etudiant etudiant = new Etudiant();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String query = "select e from Etudiant e where e.matricule=:Matricule ";

		etudiant = session.createQuery(query, Etudiant.class).setParameter("Matricule", Matricule).setMaxResults(1)
				.uniqueResult();

		session.getTransaction().commit();
		session.close();
		return etudiant;

	}
	// Retrieves a list of students by name and surname
	@Transactional
	public List<Etudiant> rechercheByNomPrenom(String Nom, String Prenom) {
		List<Etudiant> Etudiants = new ArrayList<Etudiant>();

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String query = "select e from Etudiant e where e.nom=:nom AND e.prenom =: prenom";

		Etudiants = session.createQuery(query, Etudiant.class).setParameter("nom", Nom).setParameter("prenom", Prenom)
				.list();

		session.getTransaction().commit();
		session.close();

		return Etudiants;
	}
	 // Checks the existence of a student by matricule
	public boolean verifierEtudiant(String Matricule) {
		boolean existe = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String query = "select e from Etudiant e where e.matricule=:Matricule ";
		existe = session.createQuery(query, Etudiant.class).setParameter("Matricule", Matricule).setMaxResults(1)
				.uniqueResult() != null;
		session.getTransaction().commit();
		session.close();
		return existe;

	}
	// Registers a new student
	public boolean Inscription(Etudiant etudiant) {

		boolean ajouter = true;
		if (verifierEtudiant(etudiant.getMatricule()) != true) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			java.sql.Date dateN = new java.sql.Date(etudiant.getDate_nais().getTime());
			java.sql.Date dateins = new java.sql.Date(etudiant.getDate_DerInscription().getTime());
			System.out.println(etudiant.getDate_nais().getTime());
			Query query = session.createSQLQuery(
					"insert into Etudiant(matricule,nom,prenom,sexe,date_der_inscription,prenom_pere,nom_mere,prenom_mere,faculté_id_faculté,département_id_département,formation_id_formation,niveau_id_niveau,specialité_id_specialité,university_id_university,date_nais) values"
							+ "('" + etudiant.getMatricule() + "','" + etudiant.getNom() + "','" + etudiant.getPrenom()
							+ "','" + etudiant.getSexe() + "','" + dateins + "','" + etudiant.getPrenomPere() + "','"
							+ etudiant.getNomMere() + "','" + etudiant.getPrenomMere() + "','"
							+ etudiant.getFaculté().getId_Faculté() + "','"
							+ etudiant.getDépartement().getId_Département() + "','"
							+ etudiant.getFormation().getId_Formation() + "','" + etudiant.getNiveau().getId_Niveau()
							+ "','" + etudiant.getSpecialité().getId_Specialité() + "','"
							+ etudiant.getUniversity().getId_University() + "','" + dateN + "')");

			query.executeUpdate();

			session.getTransaction().commit();
			session.close();

		} else {
			ajouter = false;
		}

		return ajouter;
	}
	// Authenticates a guard
	public boolean AuthentificationGarde(String email, String mdp) {
		boolean existe = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String query = "select e from Garde e where e.email=:email and e.password=:mdp  ";

		existe = session.createQuery(query, Garde.class).setParameter("email", email).setParameter("mdp", mdp)
				.setMaxResults(1).uniqueResult() != null;

		session.getTransaction().commit();
		session.close();
		return existe;

	}
	// Retrieves all universities
	public List<University> GetAllUniversities() {
		List<University> result = new ArrayList<University>();

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String query = "select u from University u ";
		result = session.createQuery(query, University.class).list();
		session.getTransaction().commit();
		session.close();
		return result;
	}
	// Retrieves all faculties
	public List<Faculté> GetAllFaculties() {
		List<Faculté> result = new ArrayList<Faculté>();

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String query = "select f from Faculté f ";
		result = session.createQuery(query, Faculté.class).list();
		session.getTransaction().commit();
		session.close();
		return result;
	}
	// Retrieves all Departments
	public List<Département> GetAllDépartements() {
		List<Département> result = new ArrayList<Département>();

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String query = "select f from Département f ";
		result = session.createQuery(query, Département.class).list();
		session.getTransaction().commit();
		session.close();
		return result;
	}
	// Retrieves all formations
	public List<Formation> GetAllFormations() {
		List<Formation> result = new ArrayList<Formation>();

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String query = "select f from Formation f ";
		result = session.createQuery(query, Formation.class).list();
		session.getTransaction().commit();
		session.close();
		return result;
	}
	// Retrieves all levels
	public List<Niveau> GetAllNiveaus() {
		List<Niveau> result = new ArrayList<Niveau>();

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String query = "select n from Niveau n ";
		result = session.createQuery(query, Niveau.class).list();
		session.getTransaction().commit();
		session.close();
		return result;
	}
	// Retrieves all specialities
	public List<Specialité> GetAllSpécialities() {
		List<Specialité> result = new ArrayList<Specialité>();

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String query = "select n from Specialité n ";
		result = session.createQuery(query, Specialité.class).list();
		session.getTransaction().commit();
		session.close();
		return result;
	}
	// Retrieves a university by ID
	public University GetUniversitéById(int id) {
		University result = new University();

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String query = "select u from University u where u.Id_Université=:Id_Université ";
		result = session.createQuery(query, University.class).setParameter("Id_Université", id).setMaxResults(1)
				.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return result;
	}
	 // Retrieves a faculty by ID
	public Faculté GetAllFacultéById(int id) {
		Faculté result = new Faculté();

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String query = "select f from Faculté f where f.Id_Faculté=:Id_Faculté ";
		result = session.createQuery(query, Faculté.class).setParameter("Id_Faculté", id).setMaxResults(1)
				.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return result;
	}
	// Retrieves a department by ID
	public Département GetDépartementById(int id) {
		Département result = new Département();

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String query = "select f from Département f where f.Id_Département=:Id_Département ";
		result = session.createQuery(query, Département.class).setParameter("Id_Département", id).setMaxResults(1)
				.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return result;
	}
	// Retrieves a formation by ID
	public Formation GetFormationById(int id) {
		Formation result = new Formation();

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String query = "select f from Formation f where f.Id_Formation=:Id_Formation";
		result = session.createQuery(query, Formation.class).setParameter("Id_Formation", id).setMaxResults(1)
				.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return result;
	}
	// Retrieves a level by ID
	public Niveau GetNiveauById(int id) {
		Niveau result = new Niveau();

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String query = "select n from Niveau n where n.Id_Niveau=:Id_Niveau  ";
		result = session.createQuery(query, Niveau.class).setParameter("Id_Niveau", id).setMaxResults(1).uniqueResult();
		session.getTransaction().commit();
		session.close();
		return result;
	}
	// Retrieves a speciality by ID
	public Specialité GetSpécialitéById(int id) {
		Specialité result = new Specialité();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String query = "select n from Specialité n where n.Id_Specialité=:Id_Specialité  ";
		result = session.createQuery(query, Specialité.class).setParameter("Id_Specialité", id).setMaxResults(1)
				.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return result;
	}

}
