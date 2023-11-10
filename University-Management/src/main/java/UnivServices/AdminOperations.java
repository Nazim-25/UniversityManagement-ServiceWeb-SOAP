package UnivServices;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import Beans.Etudiant;
import Beans.Utilisateur;

//This class handles administrative operations related to users
public class AdminOperations {
	
	// Checks if a user exists based on provided email and password
	public boolean verifierUtilisateur(String email, String mdp) {
		boolean existe = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String query = "select e from Utilisateur e where e.email=:email and e.password=:mdp ";
		// Executes the query to check user existence
		existe = session.createQuery(query, Utilisateur.class).setParameter("email", email).setParameter("mdp", mdp)
				.setMaxResults(1).uniqueResult() != null;

		session.getTransaction().commit();
		session.close();
		return existe;

	}
	// Retrieves a user based on email and password
	public Utilisateur getUtilisateur(String email, String mot_de_passe) {
		Utilisateur admin = new Utilisateur();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String query = "select e from Utilisateur e where e.email=:email AND e.password =: mot_de_passe ";
		// Executes the query to get the user
		admin = session.createQuery(query, Utilisateur.class).setParameter("email", email)
				.setParameter("mot_de_passe", mot_de_passe).setMaxResults(1).uniqueResult();

		session.getTransaction().commit();
		session.close();
		return admin;

	}
	// Checks if a user with a specific email exists
	public boolean checkMailUser(String email) {
		boolean existe = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String query = "select e from Utilisateur e where e.email=:email ";

		existe = session.createQuery(query, Utilisateur.class).setParameter("email", email).setMaxResults(1)
				.uniqueResult() != null;

		session.getTransaction().commit();
		session.close();
		return existe;

	}
	// Checks if the edited email is already exists 
	public boolean checkMailEditedUser(String oldEmail, String newEmail) {
		boolean existe = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String query = "select e from Utilisateur e where e.email=:email1 AND e.email<>:email2 ";

		existe = session.createQuery(query, Utilisateur.class).setParameter("email1", oldEmail)
				.setParameter("email2", newEmail).setMaxResults(1).uniqueResult() != null;

		session.getTransaction().commit();
		session.close();
		return existe;

	}
	// Retrieves all users except for specific ones
	public List<Utilisateur> getAllUsers(int id) {
		List<Utilisateur> result = new ArrayList<Utilisateur>();

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String query = "select e from Utilisateur e where e.id_Utilisateur<>:id1 AND e.id_Utilisateur<>:id2 ";
		int id1 = 1;

		result = session.createQuery(query, Utilisateur.class).setParameter("id1", id1).setParameter("id2", id).list();

		session.getTransaction().commit();
		session.close();
		return result;

	}
	// Retrieves a user based on their ID
	public Utilisateur getUtilisateurById(int id) {
		Utilisateur admin = new Utilisateur();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String query = "select e from Utilisateur e where e.id_Utilisateur=:id ";

		admin = session.createQuery(query, Utilisateur.class).setParameter("id", id).setMaxResults(1).uniqueResult();

		session.getTransaction().commit();
		session.close();
		return admin;

	}
	// Deletes a user based on their ID
	public void deleteUtilisateurById(int id) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Query query = session.createQuery(" DELETE from Utilisateur e where e.id_Utilisateur=:idUser");
		query.setParameter("idUser", id);
		query.executeUpdate();

		session.getTransaction().commit();
		session.close();
	}
	// Updates user information
	public void EditeUserById(Utilisateur user) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Query query = session
				.createQuery(" update  from Utilisateur e set e.nom=:nom , e.prenom=:prenom , e.email=:email , "
						+ "e.password=:password , e.type=:type , e.university=:university"
						+ " where e.id_Utilisateur=:idUser");
		query.setParameter("nom", user.getNom());
		query.setParameter("prenom", user.getPrenom());
		query.setParameter("email", user.getEmail());
		query.setParameter("password", user.getPassword());
		query.setParameter("type", user.getType());
		query.setParameter("university", user.getUniversity());
		query.setParameter("idUser", user.getId_Utilisateur());
		query.executeUpdate();
		System.out.println(user.getNom() + " " + user.getEmail() + " " + user.getId_Utilisateur());
		session.getTransaction().commit();
		session.close();
	}
	// Adds a new user to the system
	public boolean AddUser(Utilisateur user) {
		boolean existe = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createSQLQuery(
				"insert into Utilisateur(nom,prenom,email,password,type,university_id_university) values" + "('"
						+ user.getNom() + "','" + user.getPrenom() + "','" + user.getEmail() + "','"
						+ user.getPassword() + "','" + user.getType() + "','" + user.getUniversity().getId_University()
						+ "')");

		query.executeUpdate();

		session.getTransaction().commit();
		session.close();
		existe = verifierUtilisateur(user.getEmail(), user.getPassword());
		return existe;

	}
}
