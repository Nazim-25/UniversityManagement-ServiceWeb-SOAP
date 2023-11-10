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

import Beans.D�partement;
import Beans.Etudiant;
import Beans.Facult�;
import Beans.Formation;
import Beans.Garde;
import Beans.Niveau;
import Beans.Specialit�;
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
					"insert into Etudiant(matricule,nom,prenom,sexe,date_der_inscription,prenom_pere,nom_mere,prenom_mere,facult�_id_facult�,d�partement_id_d�partement,formation_id_formation,niveau_id_niveau,specialit�_id_specialit�,university_id_university,date_nais) values"
							+ "('" + etudiant.getMatricule() + "','" + etudiant.getNom() + "','" + etudiant.getPrenom()
							+ "','" + etudiant.getSexe() + "','" + dateins + "','" + etudiant.getPrenomPere() + "','"
							+ etudiant.getNomMere() + "','" + etudiant.getPrenomMere() + "','"
							+ etudiant.getFacult�().getId_Facult�() + "','"
							+ etudiant.getD�partement().getId_D�partement() + "','"
							+ etudiant.getFormation().getId_Formation() + "','" + etudiant.getNiveau().getId_Niveau()
							+ "','" + etudiant.getSpecialit�().getId_Specialit�() + "','"
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
	public List<Facult�> GetAllFaculties() {
		List<Facult�> result = new ArrayList<Facult�>();

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String query = "select f from Facult� f ";
		result = session.createQuery(query, Facult�.class).list();
		session.getTransaction().commit();
		session.close();
		return result;
	}
	// Retrieves all Departments
	public List<D�partement> GetAllD�partements() {
		List<D�partement> result = new ArrayList<D�partement>();

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String query = "select f from D�partement f ";
		result = session.createQuery(query, D�partement.class).list();
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
	public List<Specialit�> GetAllSp�cialities() {
		List<Specialit�> result = new ArrayList<Specialit�>();

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String query = "select n from Specialit� n ";
		result = session.createQuery(query, Specialit�.class).list();
		session.getTransaction().commit();
		session.close();
		return result;
	}
	// Retrieves a university by ID
	public University GetUniversit�ById(int id) {
		University result = new University();

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String query = "select u from University u where u.Id_Universit�=:Id_Universit� ";
		result = session.createQuery(query, University.class).setParameter("Id_Universit�", id).setMaxResults(1)
				.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return result;
	}
	 // Retrieves a faculty by ID
	public Facult� GetAllFacult�ById(int id) {
		Facult� result = new Facult�();

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String query = "select f from Facult� f where f.Id_Facult�=:Id_Facult� ";
		result = session.createQuery(query, Facult�.class).setParameter("Id_Facult�", id).setMaxResults(1)
				.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return result;
	}
	// Retrieves a department by ID
	public D�partement GetD�partementById(int id) {
		D�partement result = new D�partement();

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String query = "select f from D�partement f where f.Id_D�partement=:Id_D�partement ";
		result = session.createQuery(query, D�partement.class).setParameter("Id_D�partement", id).setMaxResults(1)
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
	public Specialit� GetSp�cialit�ById(int id) {
		Specialit� result = new Specialit�();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String query = "select n from Specialit� n where n.Id_Specialit�=:Id_Specialit�  ";
		result = session.createQuery(query, Specialit�.class).setParameter("Id_Specialit�", id).setMaxResults(1)
				.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return result;
	}

}
