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

import org.apache.commons.lang3.StringUtils;

import Beans.University;
import Beans.Utilisateur;
import UnivServices.AdminOperations;

/**
 * Manages user accounts such as deletion, editing, and display.
 */
@WebServlet(name = "afficher", urlPatterns = { "/AfficherComptes", "/deleteUser", "/editUser", "/editeUser.do" })
public class CompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CompteServlet() {

	}

	/**
	 * Handles GET requests for user accounts.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Obtain the path from the request
		String path = request.getServletPath();
		HttpSession session = request.getSession();

		AdminOperations adOp = new AdminOperations();
		// Handles user deletion
		if (path.equals("/deleteUser")) {
			// Verifies if the admin is logged in
			if (session.getAttribute("AdminConnected") != null) {
				
				int idUser = Integer.parseInt(request.getParameter("idUser"));
				adOp.deleteUtilisateurById(idUser); 
				session.setAttribute("UserDeleted", "Le compte à éte supprimier");
				response.sendRedirect(request.getContextPath() + "/AfficherComptes");
			} else {
				response.sendRedirect(request.getContextPath() + "/login");
			}
		} else if (path.equals("/editUser")) {
			 // Handles editing user details if the admin is logged in
			if (session.getAttribute("AdminConnected") != null) {
				int idUser = Integer.parseInt(request.getParameter("idUser"));
				Utilisateur user = new Utilisateur();
				user = adOp.getUtilisateurById(idUser);
				session.setAttribute("UserToEdit", user);
				session.setAttribute("UserUnivIdToEdit", user.getUniversity().getId_University());
				session.setAttribute("UserTypeToEdit", user.getType());
				session.setAttribute("UserOldEmail", user.getEmail());
				request.getRequestDispatcher("/WEB-INF/EditeCompte.jsp").forward(request, response);
			} else {
				response.sendRedirect(request.getContextPath() + "/login");
			}
		} else if (path.equals("/AfficherComptes")) {
			// Displays user accounts if the admin is logged in
			if (session.getAttribute("AdminConnected") != null) {
				List<Utilisateur> AllUsers = new ArrayList<Utilisateur>();
				Utilisateur user = new Utilisateur();
				user = (Utilisateur) session.getAttribute("Admin");

				AllUsers = adOp.getAllUsers(user.getId_Utilisateur());
				session.setAttribute("AllUsers", AllUsers);
				// Forwards to the page that displays user accounts.
				request.getRequestDispatcher("/WEB-INF/AfficherComptes.jsp").forward(request, response);
			} else {
				// If unauthorized, redirects to the login page.
				response.sendRedirect(request.getContextPath() + "/login");
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String path = request.getServletPath();
		AdminOperations adOp = new AdminOperations();
		if (path.equals("/editeUser.do")) {
			 // Processes user account modifications
			if (session.getAttribute("AdminConnected") != null) {
				// Collects user account details to be edited from the submitted form.
				Utilisateur user = new Utilisateur();
				Utilisateur user2 = new Utilisateur();
				user2 = (Utilisateur) session.getAttribute("UserToEdit");
				String nom = request.getParameter("nom");
				String prenom = request.getParameter("prenom");
				String email = request.getParameter("email");
				String mdp = request.getParameter("pwd");
				String type = request.getParameter("type");
				int id_university = Integer.parseInt(request.getParameter("Univ"));
				user.setId_Utilisateur(user2.getId_Utilisateur());
				user.setNom(nom);
				user.setPrenom(prenom);
				user.setEmail(email);
				user.setPassword(mdp);
				user.setType(type);
				University univ = new University(id_university);
				user.setUniversity(univ);

				// Modifies the user account and checks for existing email before saving changes.
				String OldEmail = (String) session.getAttribute("UserOldEmail");
				boolean existe = adOp.checkMailEditedUser(email, OldEmail);
				if (!existe) {
					adOp.EditeUserById(user);
					session.setAttribute("AdminEditedSucces", "Compte à été bien modifier");
					// Redirects to the user account display page after successful edits.
					response.sendRedirect(request.getContextPath() + "/AfficherComptes");
				} else {
					session.setAttribute("EmailExiste", "email deja utiliser");
					response.sendRedirect(request.getContextPath() + "/editUser?idUser=" + user2.getId_Utilisateur());

				}

			} else {
				// If unauthorized, redirects to the login page.
				response.sendRedirect(request.getContextPath() + "/login");
			}
		}
	}

}
