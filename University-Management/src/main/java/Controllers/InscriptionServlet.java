package Controllers;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.D�partement;
import Beans.Etudiant;
import Beans.Facult�;
import Beans.Formation;
import Beans.Niveau;
import Beans.Specialit�;
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
			List<Facult�> Faculties = new ArrayList<Facult�>();
			List<D�partement> D�partements = new ArrayList<D�partement>();
			List<Specialit�> Specialit�s = new ArrayList<Specialit�>();
			List<Niveau> Niveaus = new ArrayList<Niveau>();
			Universities = proxy.GetAllUniversities();
			Formations = proxy.GetAllFormations();
			Faculties = proxy.GetAllFaculties();
			D�partements = proxy.GetAllD�partements();
			Specialit�s = proxy.GetAllSp�cialities();
			Niveaus = proxy.GetAllNiveaus();
			session.setAttribute("Universities", Universities);
			session.setAttribute("Formations", Formations);
			session.setAttribute("Faculties", Faculties);
			session.setAttribute("D�partements", D�partements);
			session.setAttribute("Specialit�s", Specialit�s);
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
				int id_facult� = Integer.parseInt(request.getParameter("facult�"));
				int id_deparatement = Integer.parseInt(request.getParameter("deparatement"));
				int id_specialit� = Integer.parseInt(request.getParameter("specialit�"));
				int id_niveau = Integer.parseInt(request.getParameter("niveau"));
				int id_university = Integer.parseInt(request.getParameter("university"));

				System.out.println(" id's = " + id_formation + " " + id_facult� + " " + id_deparatement + " "
						+ id_specialit� + " " + id_niveau + " " + id_university);
				
				// Creates an instance of EtudiantOperations (Student Operations)
				EtudiantOperations proxy = new EtudiantOperations();

				boolean fac = false;
				boolean dep = false;
				boolean spe = false;
				// Lists to store retrieved departments and specialties
				List<D�partement> D�partements = new ArrayList<D�partement>();
				List<Specialit�> Specialit�s = new ArrayList<Specialit�>();

				// Objects to store specific education information
				Formation formation = new Formation();
				Facult� facult� = new Facult�();
				D�partement depatment = new D�partement();
				formation = proxy.GetFormationById(id_formation);
				facult� = proxy.GetAllFacult�ById(id_facult�);
				depatment = proxy.GetD�partementById(id_deparatement);
				
				// Verifies if the received IDs correspond to existing data
	            // Also checks for proper relationships between the entities
	            // (e.g., the department within the faculty)
	            //... (validation checks)
				if (formation.getFacult�().getId_Facult�() == id_facult�) {
					fac = true;
				}
				D�partements = facult�.getD�partement();
				Specialit�s = depatment.getSpecialit�();
				for (D�partement departement : D�partements) {
					if (departement.getId_D�partement() == id_deparatement) {
						dep = true;
					}
				}
				for (Specialit� speciality : Specialit�s) {
					if (speciality.getId_Specialit�() == id_specialit�) {
						spe = true;
					}
				}
				// If the provided data does not match expected relationships,
	            // returns a message and re-displays the registration page
				if (!(fac && dep && spe)) {
					session.setAttribute("wrongData", "Les informations saisies sont erron�es");
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

					a.setFacult�(new Facult�(id_facult�));
					a.setD�partement(new D�partement(id_deparatement));
					a.setSpecialit�(new Specialit�(id_deparatement));
					a.setFormation(new Formation(id_formation));
					a.setNiveau(new Niveau(id_niveau));
					a.setUniversity(new University(id_university));

					a.setDate_DerInscription(new java.sql.Date(d2.getTime()));
					// Performs student registration through the proxy
					boolean b = proxy.Inscription(a);
					System.out.println(b);
					if (!b) {
						// If the registration fails, indicates the failure and re-displays the form
						session.setAttribute("MatriculeExiste", "Matricule d�ja utiliser tester un autre ");
						//... (forwards the request to the registration page)
						request.getRequestDispatcher("/WEB-INF/Inscription.jsp").forward(request, response);

					} else {
						// If registration is successful, shows a success message and redirects to the respective dashboard
						session.setAttribute("EtudiantAjouter", "L'�tudiant � �t� bien ajouter");
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
