package Servlets;

import java.io.IOException;


import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Database_stuff.PaameldteDAO;

//@WebServlet("/Login")
@WebServlet(name = "Login", urlPatterns = "/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private PaameldteDAO paameldteDAO;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		String loginMelding = "";
		
		if(request.getParameter("invalidSession") != null) {
			loginMelding = "Det har skjedd en feil. Vennligst logg inn på nytt :)";
		}else if(request.getParameter("invalidInput") != null){
			loginMelding = "Hippity Hoppity this is not your property. Feil brukernavn eller passord!";
		}
		
		request.setAttribute("loginMelding", loginMelding);
		
		request.getRequestDispatcher("WEB-INF/jsp/logginn.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("mobil") != "" && request.getParameter("passord") != "" && 
				paameldteDAO.sjekkLogin(request.getParameter("passord"), request.getParameter("mobil"))) {
			
			String username = request.getParameter("mobil");
			
			HttpSession session = request.getSession(false);
			if(session != null) {
				session.invalidate();
			}
			session = request.getSession(true);
			session.setAttribute("mobil", username);
			
			response.sendRedirect("Deltakerliste");
		}else {
			
			response.sendRedirect("Login" + "?invalidInput");
		}
		
	}

}
