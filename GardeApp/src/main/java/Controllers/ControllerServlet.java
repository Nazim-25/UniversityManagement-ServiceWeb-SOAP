package Controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * The ControllerServlet manages requests for the home page.
 */
@WebServlet(name = "ControllerServlet", urlPatterns = { "/Home" })
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		super.init();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 // Initiates a session to handle user login status
		HttpSession session = request.getSession();
		// Checks if a user is connected by verifying the "GardeConnected" attribute
		if (session.getAttribute("GardeConnected") != null) {
			// Removes prior attributes if found in the session
			if (session.getAttribute("EmptyList") != null) {
				session.removeAttribute("EmptyList");
			}
			if (session.getAttribute("list") != null) {
				session.removeAttribute("list");
			}
			// Forwards the request to the home page if user is authenticated
			request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		} else {
			// Redirects to the "loginG" link if the user is not authenticated
			response.sendRedirect(request.getContextPath() + "/loginG");
		}

	}
}
