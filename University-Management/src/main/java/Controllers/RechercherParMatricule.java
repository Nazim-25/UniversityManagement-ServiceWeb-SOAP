package Controllers;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.Etudiant;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import UnivServices.EtudiantOperations;

/**
 * Manages searching for students by their registration number (matricule).
 */
@WebServlet(name = "Rpms", urlPatterns = { "/Matricule", "/ChercherParMatricule.do" })
public class RechercherParMatricule extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RechercherParMatricule() {

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if (session.getAttribute("AdminConnected") != null || session.getAttribute("AgentConnected") != null) {
			 // Clears session attributes and forwards to the search page
			if (session.getAttribute("EmptyList") != null) {
				session.removeAttribute("EmptyList");
				System.out.println("message removed");
			}
			if (session.getAttribute("list") != null) {

				session.removeAttribute("list");
				System.out.println("list removed");
			}
			if (session.getAttribute("EtudiantAjouter") != null) {
				session.removeAttribute("EtudiantAjouter");
			}

			request.getRequestDispatcher("/WEB-INF/Recherche.html").forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		HttpSession session = request.getSession();

		if (path.equals("/ChercherParMatricule.do")) {
			// Checks user authorization
			if (session.getAttribute("AdminConnected") != null || session.getAttribute("AgentConnected") != null) {
				ArrayList<Etudiant> list = new ArrayList<Etudiant>();// Container to store search results
				String matricule = request.getParameter("matricule");// Extracting matricule from the request
				System.out.println("matricule : " + matricule); 
				EtudiantOperations proxy = new EtudiantOperations(); // Instance to operate on student data
				Etudiant e1 = null;
				e1 = proxy.rechercheByMatricule(matricule); // Searching for a student by matricule
				System.out.println(Objects.isNull(e1));
				 // Processing the search result
				if (e1 == null) {
					// If student doesn't exist, set session attribute for displaying a message
					session.setAttribute("EmptyList", "Etudiant n'existe pas");
				} else {
					System.out.println(e1.getNom());
					// If the student is found, store it in the list
					list.add(e1);
					session.setAttribute("list", list);
				}
				 // Forward to the results page to display the search outcome
				request.getRequestDispatcher("/WEB-INF/Résultat.jsp").forward(request, response);
			} else {
				// Redirects to the login page if unauthorized
				response.sendRedirect(request.getContextPath() + "/login");
			}
		}

		// doGet(request, response);
	}

}

/*
 * String path =request.getServletPath(); if(path.equals("/Matricule")) {
 * request.getRequestDispatcher("/WEB-INF/Matricule.html").forward(request,
 * response);
 * 
 * }else if(path.equals("/ChercherParMatricule.do")){
 * request.getRequestDispatcher("/WEB-INF/index.html").forward(request,response)
 * ; }
 */
