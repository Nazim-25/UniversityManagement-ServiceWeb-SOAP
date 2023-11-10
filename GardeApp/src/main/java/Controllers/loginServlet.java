package Controllers;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//Imports related classes from a SOAP-based service
import UnivServices.OperationEtudiantStub;
import UnivServices.OperationEtudiantStub.AuthentificationGarde;
import UnivServices.OperationEtudiantStub.AuthentificationGardeResponse;

/**
 * Handles Garde functionality for user authentication.
 */

@WebServlet(name="loginG",urlPatterns={"/loginG","/loginG.do"})
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
    
    	
		
    }

	/**
     * Handles the Get request for Garde login page.
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Forwards to the login page
		request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
	}

	/**
     * Handles the POST request for Garde login authentication.
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =  request.getSession();
		
		String path =request.getServletPath();
		if(path.equals("/loginG.do"))
		{
		// Retrieving data from the form
		String email = request.getParameter("email");
		String mdp = request.getParameter("pwd");
		// Instantiating a SOAP stub...
		OperationEtudiantStub stub=new OperationEtudiantStub();
		
		AuthentificationGarde auth = new AuthentificationGarde();
		// Setting up student authentification data..
		auth.setEmail(email);
		auth.setPassword(mdp);
		// Invoking the SOAP service
		AuthentificationGardeResponse b = stub.authentificationGarde(auth);
		// Handling the SOAP service response
		boolean existe=b.get_return();
		if(existe) {
			// Sets session attribute and forwards to index on successful login
			session.setAttribute("GardeConnected","true");
			request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request,response);
		}else {
			// Displays error message and redirects back to login page on authentication failure
			session.setAttribute("GardeNotFound", "email ou bien mot de pass incorrect");
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
			
		}
		
	}
	}
}
