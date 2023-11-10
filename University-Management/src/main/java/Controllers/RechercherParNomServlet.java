package Controllers;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import Beans.Etudiant;
import UnivServices.EtudiantOperations;

/**
 * This servlet manages the search process for students by their name.
 */
@WebServlet(name = "Rpns", urlPatterns = { "/Nom", "/ChercherParNom.do" })
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
	 * Handles the GET request to access the student name search functionality.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		// Checks user authorization for search functionality
		if (session.getAttribute("AdminConnected") != null || session.getAttribute("AgentConnected") != null) {
			// Clears session attributes for a fresh search
			if (session.getAttribute("EmptyList") != null) {
				session.removeAttribute("EmptyList");
			}
			if (session.getAttribute("list") != null) {
				session.removeAttribute("list");
			}
			if (session.getAttribute("EtudiantAjouter") != null) {
				session.removeAttribute("EtudiantAjouter");
			}
			// Forwards to the student name search page
			request.getRequestDispatcher("/WEB-INF/Nom.jsp").forward(request, response);
		} else {
			// Redirects to the login page if unauthorized
			response.sendRedirect(request.getContextPath() + "/login");
		}
	}

	/**
	 * Handles the POST request for searching students by their name.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		HttpSession session = request.getSession();
		// On request to search students by name
		if (path.equals("/ChercherParNom.do")) {
			// Checks user authorization
			if (session.getAttribute("AdminConnected") != null || session.getAttribute("AgentConnected") != null) {
				ArrayList<Etudiant> list = new ArrayList<Etudiant>();

				String nom = request.getParameter("name");
				System.out.println(nom);
				EtudiantOperations proxy = new EtudiantOperations();

				List<Etudiant> listEtudiant = null;
				listEtudiant = proxy.rechercheByNom(nom);

				if (listEtudiant.isEmpty()) {
					session.setAttribute("EmptyList", "Etudiant n'existe pas");
					System.out.println("emptylist");
				} else {
					// Adds found students to the list
					for (Etudiant Etud : listEtudiant) {
						list.add(Etud);
					}
					System.out.println("non Empty List");
					session.setAttribute("list", list);
				}
				// Forward to the results page to display the search outcome
				request.getRequestDispatcher("/WEB-INF/Résultat.jsp").forward(request, response);
				// Redirects to the login page if unauthorized
			} else {
				response.sendRedirect(request.getContextPath() + "/login");
			}
		}
	}
}
