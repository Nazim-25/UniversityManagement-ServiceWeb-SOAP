package Controllers;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.Département;
import Beans.Etudiant;
import Beans.Faculté;
import Beans.Formation;
import Beans.Niveau;
import Beans.Specialité;
import Beans.University;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import UnivServices.EtudiantOperations;

/**
 * Servlet responsible for managing student registrations.
 */
@WebServlet(name = "Is", urlPatterns = { "/Inscription", "/Inscriptions", "/InscriptionAdmin" })
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InscriptionServlet() {
		super();

	}

	/**
     * Handles GET requests for the registration page and retrieves necessary data.
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if (session.getAttribute("AdminConnected") != null || session.getAttribute("AgentConnected") != null) {
			if (session.getAttribute("EtudiantAjouter") != null) {
				session.removeAttribute("EtudiantAjouter");
			}
			// Fetches data required for student registration
			EtudiantOperations proxy = new EtudiantOperations();
			List<Formation> Formations = new ArrayList<Formation>();
			List<University> Universities = new ArrayList<University>();
			List<Faculté> Faculties = new ArrayList<Faculté>();
			List<Département> Départements = new ArrayList<Département>();
			List<Specialité> Specialités = new ArrayList<Specialité>();
			List<Niveau> Niveaus = new ArrayList<Niveau>();
			Universities = proxy.GetAllUniversities();
			Formations = proxy.GetAllFormations();
			Faculties = proxy.GetAllFaculties();
			Départements = proxy.GetAllDépartements();
			Specialités = proxy.GetAllSpécialities();
			Niveaus = proxy.GetAllNiveaus();
			session.setAttribute("Universities", Universities);
			session.setAttribute("Formations", Formations);
			session.setAttribute("Faculties", Faculties);
			session.setAttribute("Départements", Départements);
			session.setAttribute("Specialités", Specialités);
			session.setAttribute("Niveaus", Niveaus);

			request.getRequestDispatcher("/WEB-INF/Inscription.jsp").forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/login");
		}
	}

	/**
     * Handles POST requests for student registration process.
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		if (path.equals("/Inscriptions")) {
			 // Processes student registration
			HttpSession session = request.getSession();
			// Checks if the user is an admin or agent
			if (session.getAttribute("AdminConnected") != null || session.getAttribute("AgentConnected") != null) {
				 // Retrieves student details from the form
				String nom = request.getParameter("nom");
				String prenom = request.getParameter("prenom");
				String sexe = request.getParameter("sexe");
				String prenomP = request.getParameter("prenomP");
				String nomM = request.getParameter("nomM");
				String prenomM = request.getParameter("prenomM");
				String Matricule = request.getParameter("matricule");
				String dateins = request.getParameter("dateins");
				String dateN = request.getParameter("dateN");
				System.out.println(Matricule + " " + nom + " " + prenom + " " + sexe + " " + prenomP + " " + nomM + " "
						+ prenomM + " " + dateins + " " + dateN);
				// Retrieves IDs associated with various educational elements
				int id_formation = Integer.parseInt(request.getParameter("formation"));
				int id_faculté = Integer.parseInt(request.getParameter("faculté"));
				int id_deparatement = Integer.parseInt(request.getParameter("deparatement"));
				int id_specialité = Integer.parseInt(request.getParameter("specialité"));
				int id_niveau = Integer.parseInt(request.getParameter("niveau"));
				int id_university = Integer.parseInt(request.getParameter("university"));

				System.out.println(" id's = " + id_formation + " " + id_faculté + " " + id_deparatement + " "
						+ id_specialité + " " + id_niveau + " " + id_university);
				
				// Creates an instance of EtudiantOperations (Student Operations)
				EtudiantOperations proxy = new EtudiantOperations();

				boolean fac = false;
				boolean dep = false;
				boolean spe = false;
				// Lists to store retrieved departments and specialties
				List<Département> Départements = new ArrayList<Département>();
				List<Specialité> Specialités = new ArrayList<Specialité>();

				// Objects to store specific education information
				Formation formation = new Formation();
				Faculté faculté = new Faculté();
				Département depatment = new Département();
				formation = proxy.GetFormationById(id_formation);
				faculté = proxy.GetAllFacultéById(id_faculté);
				depatment = proxy.GetDépartementById(id_deparatement);
				
				// Verifies if the received IDs correspond to existing data
	            // Also checks for proper relationships between the entities
	            // (e.g., the department within the faculty)
	            //... (validation checks)
				if (formation.getFaculté().getId_Faculté() == id_faculté) {
					fac = true;
				}
				Départements = faculté.getDépartement();
				Specialités = depatment.getSpecialité();
				for (Département departement : Départements) {
					if (departement.getId_Département() == id_deparatement) {
						dep = true;
					}
				}
				for (Specialité speciality : Specialités) {
					if (speciality.getId_Specialité() == id_specialité) {
						spe = true;
					}
				}
				// If the provided data does not match expected relationships,
	            // returns a message and re-displays the registration page
				if (!(fac && dep && spe)) {
					session.setAttribute("wrongData", "Les informations saisies sont erronées");
					//... (logs the error and redirects back to the form)
					System.out.println(fac + " , " + dep + " , " + spe);
					request.getRequestDispatcher("/WEB-INF/Inscription.jsp").forward(request, response);
				} else {
					 // Creates a new student instance with the received data
					Etudiant a = new Etudiant();
					//... (sets various student attributes)
					a.setMatricule(Matricule);
					a.setNom(nom);
					a.setPrenom(prenom);
					
					// Converts and sets date information
					SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");

					Date d1 = new Date();
					Date d2 = new Date();
					//... (date parsing and attribute assignments)
					try {
						d1 = d.parse(dateN);
						d2 = d.parse(dateins);

					} catch (ParseException e) {

						e.printStackTrace();
					}

					a.setDate_nais(new java.sql.Date(d1.getTime()));

					a.setSexe(sexe);
					;
					a.setPrenomPere(prenomP);
					a.setNomMere(nomM);
					a.setPrenomMere(prenomM);

					a.setFaculté(new Faculté(id_faculté));
					a.setDépartement(new Département(id_deparatement));
					a.setSpecialité(new Specialité(id_deparatement));
					a.setFormation(new Formation(id_formation));
					a.setNiveau(new Niveau(id_niveau));
					a.setUniversity(new University(id_university));

					a.setDate_DerInscription(new java.sql.Date(d2.getTime()));
					// Performs student registration through the proxy
					boolean b = proxy.Inscription(a);
					System.out.println(b);
					if (!b) {
						// If the registration fails, indicates the failure and re-displays the form
						session.setAttribute("MatriculeExiste", "Matricule déja utiliser tester un autre ");
						//... (forwards the request to the registration page)
						request.getRequestDispatcher("/WEB-INF/Inscription.jsp").forward(request, response);

					} else {
						// If registration is successful, shows a success message and redirects to the respective dashboard
						session.setAttribute("EtudiantAjouter", "L'étudiant à été bien ajouter");
						if (session.getAttribute("AgentConnected") != null) {
							request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
						} else if (session.getAttribute("AdminConnected") != null) {
							request.getRequestDispatcher("/WEB-INF/AdminPage.jsp").forward(request, response);
						}
					}
				}

			} else {
				 // If the user is not an admin or agent, redirects to the login page
				response.sendRedirect(request.getContextPath() + "/login");
			}
		}
	}
	/**
     * Utility function to parse a date string to a Date object.
     */
	static Date parseDate(String date, String format) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.parse(date);
	}
}
