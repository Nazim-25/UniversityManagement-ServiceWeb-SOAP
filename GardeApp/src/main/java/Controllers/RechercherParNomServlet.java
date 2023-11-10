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

import UnivServices.OperationEtudiantStub.RechercheByName;
import UnivServices.OperationEtudiantStub.RechercheByNameResponse;

/**
 * Servlet implementation class RechercherParNomServlet
 * 
 * This servlet handles the search for a student by their name.
 */
@WebServlet(name = "RpnsG", urlPatterns = { "/NomG", "/ChercherParNomG.do" })
public class RechercherParNomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RechercherParNomServlet() {
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
		HttpSession session = request.getSession();
		// Check if the Garde is logged in
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
			request.getRequestDispatcher("/WEB-INF/Nom.jsp").forward(request, response);
		} else {
			 // Redirect the user to the login page
			response.sendRedirect(request.getContextPath() + "/loginG");
		}
	}

	/**
     * Handles POST requests.
     * 
     * This method handles the search for a student by their name. It uses a SOAP-based
     * service to perform the search and returns the results to the user.
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 // Get the servlet path and session object
		String path = request.getServletPath();
		HttpSession session = request.getSession();
		if (path.equals("/ChercherParNomG.do")) {
			 // Check if the Garde is logged in
			if (session.getAttribute("GardeConnected") != null) {
				ArrayList<Etudiant> list = new ArrayList<Etudiant>();
				// Create a stub for the SOAP-based service
				OperationEtudiantStub stub = new OperationEtudiantStub();
				// Get the name from the request
				String nom = request.getParameter("name");
				// Create a RechercheByName object to hold the search criteria
				RechercheByName rechercher = new RechercheByName();
				rechercher.setName(nom);
				// Call the SOAP-based service to perform the search
				RechercheByNameResponse response1 = stub.rechercheByName(rechercher);
				
				response1.get_return();
				Etudiant[] listEtudiant = null;
				// Get the search results from the response
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
