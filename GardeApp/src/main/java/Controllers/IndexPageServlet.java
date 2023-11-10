package Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Manages the index page redirection based on user sessions.
 */
@WebServlet(name = "indexServlet", urlPatterns = { "/IndexPage" })
public class IndexPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexPageServlet() {

	}

	/**
	 * Processes GET requests, redirects based on user session status.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Initiates a session to handle Garde login status
		HttpSession session = request.getSession();
		if (session.getAttribute("GardeConnected") != null) {
			// Forwards the request to the home page if Garde is authenticated
			response.sendRedirect(request.getContextPath() + "/Home");
		} else {
			// Redirects to the "loginG" link if the Garde is not authenticated
			response.sendRedirect(request.getContextPath() + "/loginG");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Delegates POST requests to the doGet method.
		doGet(request, response);
	}

}
