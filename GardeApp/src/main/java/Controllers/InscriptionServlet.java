package Controllers;

import java.io.IOException;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//Imports related classes from a SOAP-based service
import UnivServices.OperationEtudiantStub;
import UnivServices.OperationEtudiantStub.Etudiant;
import UnivServices.OperationEtudiantStub.University;
import UnivServices.OperationEtudiantStub.Specialité;
import UnivServices.OperationEtudiantStub.Niveau;
import UnivServices.OperationEtudiantStub.Formation;
import UnivServices.OperationEtudiantStub.Inscription;
import UnivServices.OperationEtudiantStub.InscriptionResponse;

import UnivServices.OperationEtudiantStub.Faculté;

import UnivServices.OperationEtudiantStub.Département;

import javax.servlet.annotation.WebServlet;

/**
 * Manages student registrations, both for displaying the form and handling form submission.
 */
@WebServlet(name = "IsG", urlPatterns = { "/InscriptionG", "/InscriptionsG" })
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InscriptionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * Handles GET requests, displaying the registration form if 'GardeConnected' session is active.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("GardeConnected") != null) {
			// Forwards to the registration page if the session is active
			request.getRequestDispatcher("/WEB-INF/Inscription.jsp").forward(request, response);
		} else {
			// Redirects to the login page if the garde is not connected
			response.sendRedirect(request.getContextPath() + "/loginG");
		}
	}

	/**
	 * Handles POST requests for student registrations.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		if (path.equals("/InscriptionsG")) {

			HttpSession session = request.getSession();
			
			// Retrieving form input data...
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
			// Retrieving form input data...
			int id_formation = Integer.parseInt(request.getParameter("formation"));
			int id_faculté = Integer.parseInt(request.getParameter("faculté"));
			int id_deparatement = Integer.parseInt(request.getParameter("deparatement"));
			int id_specialité = Integer.parseInt(request.getParameter("specialité"));
			int id_niveau = Integer.parseInt(request.getParameter("niveau"));
			int id_university = Integer.parseInt(request.getParameter("university"));

			System.out.println(" id's = " + id_formation + " " + id_faculté + " " + id_deparatement + " "
					+ id_specialité + " " + id_niveau + " " + id_university);
			// Instantiating a SOAP stub...
			OperationEtudiantStub stub = new OperationEtudiantStub();

			Etudiant a = new Etudiant();
			// Setting up student data..
			a.setMatricule(Matricule);
			a.setNom(nom);
			a.setPrenom(prenom);
			SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
			// Parsing and setting date values
			Date d1 = new Date();
			Date d2 = new Date();

			try {
				d1 = d.parse(dateN);
				d2 = d.parse(dateins);

			} catch (ParseException e) {

				e.printStackTrace();
			}

			a.setDate_nais(new java.sql.Date(d1.getTime()));

			a.setSexe(sexe);
			
			a.setPrenomPere(prenomP);
			a.setNomMere(nomM);
			a.setPrenomMere(prenomM);
			Faculté fa = new Faculté();
			fa.setId_Faculté(id_faculté);
			a.setFaculté(fa);
			// Setting up student's details...
			Département de = new Département();
			de.setId_Département(id_deparatement);
			a.setDépartement(de);
			Specialité sp = new Specialité();
			sp.setId_Specialité(id_specialité);
			a.setSpecialité(sp);
			Formation fr = new Formation();
			fr.setId_Formation(id_formation);
			a.setFormation(fr);
			Niveau nv = new Niveau();
			nv.setId_Niveau(id_niveau);
			a.setNiveau(nv);
			University univ = new University();
			univ.setId_University(id_university);
			a.setUniversity(univ);

			a.setDate_DerInscription(new java.sql.Date(d2.getTime()));
			// Invoking the SOAP service
			Inscription insp = new Inscription();
			insp.setEtudiant(a);

			InscriptionResponse InR = stub.inscription(insp);
			// Handling the SOAP service response
			boolean b = InR.get_return();
			System.out.println(b);
			// Check the response and provide appropriate messages
			if (!b) {
				session.setAttribute("MatriculeExiste", "Matricule déja utiliser tester un autre ");
				// In case of registration failure, stay on the registration page and display a message
				request.getRequestDispatcher("/WEB-INF/Inscription.jsp").forward(request, response);

			} else {
				session.setAttribute("EtudiantAjouter", "L'étudiant à été bien ajouter");
				// On successful registration, go to the index page and display a success message
				request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);

			}
			/*
			 * }else { response.sendRedirect(request.getContextPath() + "/login"); }
			 */
		}
	}

}