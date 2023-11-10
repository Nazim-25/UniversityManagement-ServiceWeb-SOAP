package Controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import Beans.University;
import Beans.Utilisateur;
import UnivServices.AdminOperations;

/**
 * This class represents a servlet to add user accounts in the system.
 */
@WebServlet(name = "ajouter", urlPatterns = { "/AjouterCompte", "/AjouterCompte.do" })
public class AjouterCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjouterCompteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
     * Handles HTTP GET requests to the servlet.
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("AdminConnected") != null) {
			request.getRequestDispatcher("/WEB-INF/AjouterCompte.jsp").forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/login");
		}
	}

	 /**
     * Handles HTTP POST requests to the servlet.
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String path = request.getServletPath();
		if (path.equals("/AjouterCompte.do")) {
			if (session.getAttribute("AdminConnected") != null) {
				AdminOperations adOp = new AdminOperations();
				Utilisateur user = new Utilisateur();

				request.getParameter("nom");
				String nom = request.getParameter("nom");
				String prenom = request.getParameter("prenom");
				String email = request.getParameter("email");
				String mdp = request.getParameter("pwd");
				String type = request.getParameter("type");
				int id_university = Integer.parseInt(request.getParameter("Univ"));
				
				// Set user data obtained from the request
				user.setNom(nom);
				user.setPrenom(prenom);
				user.setEmail(email);
				user.setPassword(mdp);
				user.setType(type);
				
				// Set the university for the user
				University univ = new University(id_university);
				user.setUniversity(univ);
				// Check if the email exists
				boolean existe = adOp.checkMailUser(email);

				if (!existe) {
					boolean added = false;
					added = adOp.AddUser(user);
					session.setAttribute("AdminAjouter", StringUtils.capitalize(type) + " a éte bien Ajouter");
					response.sendRedirect(request.getContextPath() + "/AfficherComptes");
				} else {
					session.setAttribute("AdminExiste", "email deja utiliser");
					request.getRequestDispatcher("/WEB-INF/AjouterCompte.jsp").forward(request, response);

				}
			} else {
				// If the user is not an admin or agent, redirects to the login page
				response.sendRedirect(request.getContextPath() + "/login");
			}
		}
	}

}
