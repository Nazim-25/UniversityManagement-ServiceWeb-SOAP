package Controllers;

import java.io.IOException;


import java.util.ArrayList;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//Imports related classes from a SOAP-based service
import UnivServices.OperationEtudiantStub;
import UnivServices.OperationEtudiantStub.Etudiant;
import UnivServices.OperationEtudiantStub.RechercheByMatricule;
import UnivServices.OperationEtudiantStub.RechercheByMatriculeResponse;

/**
 * Servlet implementation class RechercheParMatricule
 * 
 * This servlet handles the search for a student by their matriculation number.
 */
@WebServlet(name = "RpmsG", urlPatterns = { "/Matricule", "/ChercherParMatricule.do" })
public class RechercheParMatricule extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RechercheParMatricule() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
     * Handles GET requests.
     * 
     * This method checks if the user is logged in and, if so, forwards the request to
     * the search page. Otherwise, it redirects the user to the login page.
    **/
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
			request.getRequestDispatcher("/WEB-INF/Recherche.html").forward(request, response);
		} else {
			 // Redirect the user to the login page
			response.sendRedirect(request.getContextPath() + "/loginG");
		}
	}

	/**
     * Handles POST requests.
     * 
     * This method handles the search for a student by their matriculation number. It
     * uses a SOAP-based service to perform the search and returns the results to the
     * user.
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get the servlet path
		String path = request.getServletPath();
		 // Get the session object
		HttpSession session = request.getSession();

		if (path.equals("/ChercherParMatricule.do")) {
			// Check if the Garde is logged in
			if (session.getAttribute("GardeConnected") != null) {
				// Create an ArrayList to store the search results
				ArrayList<Etudiant> list = new ArrayList<Etudiant>();
				// Create an empty Etudiant object to use as a placeholder in the ArrayList
				Etudiant a2 = new Etudiant();
				list.add(a2);
				// Get the matriculation number from the request
				String matricule = request.getParameter("matricule");
				// Create a stub for the SOAP-based service
				OperationEtudiantStub stub = new OperationEtudiantStub();
				Etudiant e1 = new Etudiant();
				e1.setMatricule("");
				// Create a RechercheByMatricule object to hold the search criteria
				RechercheByMatricule rechercher = new RechercheByMatricule();
				rechercher.setMatricule(matricule);
				// Call the SOAP-based service to perform the search
				RechercheByMatriculeResponse response1 = stub.rechercheByMatricule(rechercher);
				// Get the search results from the response
				e1 = response1.get_return();
				// Check if the search results are empty
				if (e1.getMatricule() == null) {
					// Set an attribute in the session to indicate that the search results are empty
					session.setAttribute("EmptyList", "Etudiant n'existe pas");

				} else {
					// Set an attribute in the session to store the search results
					System.out.println(e1.getNom());
					list.add(e1);
					session.setAttribute("Etudiant1", e1);
				}
				// Forward the request to the results page
				request.getRequestDispatcher("/WEB-INF/ResultatMatricule.jsp").forward(request, response);
			}
		} else {
			 // Redirect the user to the login page
			response.sendRedirect(request.getContextPath() + "/loginG");
		}
	}

}
