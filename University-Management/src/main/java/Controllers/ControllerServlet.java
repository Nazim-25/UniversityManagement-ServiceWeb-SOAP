package Controllers;

import java.io.IOException;


import UnivServices.EtudiantOperations;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.Etudiant;

@WebServlet(name="AgentHome",urlPatterns={"/Home"})
public class ControllerServlet extends HttpServlet{
	
	@Override
	public void init() throws ServletException{
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session =  request.getSession();
		if(session.getAttribute("AgentConnected")!=null ) {
		if(session.getAttribute("EmptyList") !=null) {
		session.removeAttribute("EmptyList");
		}
		if(session.getAttribute("list") !=null) {
			session.removeAttribute("list");
		}
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request,response);
		}else {
			response.sendRedirect(request.getContextPath() + "/login");
		}
		
	}
}
