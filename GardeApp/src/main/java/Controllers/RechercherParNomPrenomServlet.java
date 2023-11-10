package Controllers;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//Imports related classes from a SOAP-based service
import UnivServices.OperationEtudiantStub;
import UnivServices.OperationEtudiantStub.Etudiant;
import UnivServices.OperationEtudiantStub.RechercheByNomPrenom;
import UnivServices.OperationEtudiantStub.RechercheByNomPrenomResponse;

/**
 * Servlet implementation class RechercherParNomPrenomServlet
 * 
 * This servlet handles the search for a student by their name and first name.
 */
@WebServlet(name = "RpnpsG", urlPatterns = { "/Nom-prenomG", "/ChercherParNomPrenomG.do" })
public class RechercherParNomPrenomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RechercherParNomPrenomServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Handles GET requests.
	 * 
	 * This method checks if the user is logged in and, if so, forwards the request
	 * to the search page. Otherwise, it redirects the user to the login page.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get the session object
		HttpSession session = request.getSession();
		// Check if the garde is logged in
		if (session.getAttribute("GardeConnected") != null) {
			// Remove any previous search results or messages from the session
			if (session.getAttribute("EmptyList") != null) {
				session.removeAttribute("EmptyList");
			}
			if (session.getAttribute("list") != null) {
				session.removeAttribute("list");
			}
			if (session.getAttribute("EtudiantAjouter") != null) {
				session.removeAttribute("EtudiantAjouter");
			}
			// Forward the request to the search page
			request.getRequestDispatcher("/WEB-INF/Nom-prenom.jsp").forward(request, response);
		} else {
			// Redirect the user to the login page
			response.sendRedirect(request.getContextPath() + "/loginG");
		}
	}

	/**
	 * Handles POST requests.
	 * 
	 * This method handles the search for a student by their name and first name. It
	 * uses a SOAP-based service to perform the search and returns the results to
	 * the user.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();

		if (path.equals("/ChercherParNomPrenomG.do")) {
			HttpSession session = request.getSession();
			// Check if the garde is logged in
			if (session.getAttribute("GardeConnected") != null) {
				ArrayList<Etudiant> list = new ArrayList<Etudiant>();
				// Create a stub for the SOAP-based service
				OperationEtudiantStub stub = new OperationEtudiantStub();
				// Get the name and first name from the request
				String nom = request.getParameter("name");
				String prenom = request.getParameter("prenom");
				// Create a RechercheByNomPrenom object to hold the search criteria
				RechercheByNomPrenom rechercher = new RechercheByNomPrenom();
				rechercher.setNom(nom);
				rechercher.setPrenom(prenom);
				 // Call the SOAP-based service to perform the search
				RechercheByNomPrenomResponse response1 = stub.rechercheByNomPrenom(rechercher);
				// Get the search results from the response
				response1.get_return();
				Etudiant[] listEtudiant = null;
				listEtudiant = response1.get_return();
				if (listEtudiant == null) {
					// Set an attribute in the session to indicate that the search results are empty
					session.setAttribute("EmptyList", "Etudiant n'existe pas");
					System.out.println("emptylist");

				} else {
					 // Add the search results to the ArrayList
					for (Etudiant Etud : listEtudiant) {
						list.add(Etud);
					}
					 // Set an attribute in the session to store the search results
					session.setAttribute("list", list);
					System.out.println("Non emptylist");
				}
				// Forward the request to the results page
				request.getRequestDispatcher("/WEB-INF/Résultat.jsp").forward(request, response);
			} else {
				// Redirect the user to the login page
				response.sendRedirect(request.getContextPath() + "/loginG");
			}
		}

	}
}
