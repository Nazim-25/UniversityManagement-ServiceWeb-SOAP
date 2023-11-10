package Controllers;

import javax.servlet.ServletException;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.Utilisateur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import UnivServices.AdminOperations;
import UnivServices.EtudiantOperations;

/**
 * Handles login functionality for user authentication.
 */
@WebServlet(name = "login", urlPatterns = { "/login", "/login.do" })
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
     * Initializes the servlet instance.
     */
	public loginServlet() {
		EtudiantOperations op = new EtudiantOperations();
		op.rechercheByNom("test");

	}

	/**
     * Handles the GET request for the login page.
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Directs to the login page for GET requests
		request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	 /**
     * Handles the POST request for user login authentication.
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		// Retrieves the path from the request
		String path = request.getServletPath();
		if (path.equals("/login.do")) {
			// Handles user authentication through AdminOperations
			AdminOperations adOp = new AdminOperations();
			String email = request.getParameter("email");
			String mdp = request.getParameter("pwd");
			// Verifies user credentials
			boolean existe = adOp.verifierUtilisateur(email, mdp);
			System.out.println(existe);
			if (existe) {
				// If the user exists, retrieves the user and redirects based on user type
				Utilisateur admin = adOp.getUtilisateur(email, mdp);
				if (admin.getType().equals("admin")) {
					// Sets session attribute for an admin and forwards to the Admin page
					session.setAttribute("AdminConnected", "true");
					request.getRequestDispatcher("/WEB-INF/AdminPage.jsp").forward(request, response);

					session.setAttribute("Admin", admin);
				} else {
					 // Sets session attribute for an agent and forwards to the user dashboard
					session.setAttribute("AgentConnected", "true");
					request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
				}
			} else {
				 // If user credentials are incorrect, returns to the login page with an error message
				session.setAttribute("AdminNotFound", "email ou bien mot de pass incorrect");
				request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
			}

		}
	}

}
