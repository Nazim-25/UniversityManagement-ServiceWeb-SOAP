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
import java.util.List;

import UnivServices.EtudiantOperations;


/**
 * This servlet class manages the search process for students based on their name and surname.
 */
@WebServlet(name="Rpnps",urlPatterns={"/Nom-prenom","/ChercherParNomPrenom.do"})
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
	 * Handles the GET request for searching students by name and surname.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session =  request.getSession();
		// Checks user authorization for search functionality
		if(session.getAttribute("AdminConnected")!=null || session.getAttribute("AgentConnected")!=null) {
			// Clears session attributes for a fresh search
		if(session.getAttribute("EmptyList") !=null) {
			session.removeAttribute("EmptyList");
		}
		if(session.getAttribute("list") !=null) {
			session.removeAttribute("list");
		}
		if(session.getAttribute("EtudiantAjouter") !=null) {		
			session.removeAttribute("EtudiantAjouter");	
		}
		// Forwards to the search page for name and surname
		request.getRequestDispatcher("/WEB-INF/Nom-prenom.jsp").forward(request,response);
		}else {
			// Redirects to the login page if unauthorized
			response.sendRedirect(request.getContextPath() + "/login");
		}
	}

	/**
	 * Handles the POST request for searching students by name and surname.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path =request.getServletPath();
		ArrayList<Etudiant> list = new ArrayList<Etudiant>();
		// On request to search students by name and surname
		if(path.equals("/ChercherParNomPrenom.do"))
		{
			HttpSession session =  request.getSession();
			// Checks user authorization
		if(session.getAttribute("AdminConnected")!=null || session.getAttribute("AgentConnected")!=null) {
		String nom = request.getParameter("name");
		String prenom = request.getParameter("prenom");
		System.out.println("nom : "+nom+" prenom : "+prenom);
		EtudiantOperations proxy = new EtudiantOperations();
		List<Etudiant> listEtudiant= null;
		listEtudiant = proxy.rechercheByNomPrenom(nom, prenom);
		if(listEtudiant.isEmpty() ) {
			session.setAttribute("EmptyList", "Etudiant n'existe pas");
			System.out.println("emptylist");
		
		}else {
			// Adds the found students to the list
		for(Etudiant Etud:listEtudiant) {
			list.add(Etud);
		}
		session.setAttribute("list", list);
		System.out.println("Non emptylist");
		}
		// Forward to the results page to display the search outcome
		request.getRequestDispatcher("/WEB-INF/Résultat.jsp").forward(request,response);
		}else {
			// Redirects to the login page if unauthorized
			response.sendRedirect(request.getContextPath() + "/login");
		}
		}
	
		
	}
}
