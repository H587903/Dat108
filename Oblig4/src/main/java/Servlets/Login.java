package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;


import Database_stuff.Paameldte;
import Database_stuff.PaameldteDAO;

//@WebServlet("/Login")
@WebServlet(name = "Login", urlPatterns = "/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private PaameldteDAO paameldteDAO;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List<Paameldte> liste = paameldteDAO.visDeltakerListe();
		
		response.setContentType(MediaType.TEXT_PLAIN);
		PrintWriter out = response.getWriter();
		
		liste.forEach(out::println);
		
		
//		String loginMelding = "";
//		
//		if(request.getParameter("invalidSession") != null) {
//			loginMelding = "Det har skjedd en feil. Vennligst logg inn på nytt :)";
//		}else if(request.getParameter("invalidInput") != null){
//			loginMelding = "Hippity Hoppity this is not your property. Feil brukernavn eller passord!";
//		}
//		
//		request.setAttribute("loginMelding", loginMelding);
//		
//		request.getRequestDispatcher("WEB-INF/jsp/logginn.jsp").forward(request, response);
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		//if brukernavn && passord finst i database
//		//Send til deltakerliste ved korrekt mobilnummer og passord
//		
//		if(request.getParameter("mobil") != "" && request.getParameter("passord") != "") {
//			String username = request.getParameter("mobil");
//			
//			HttpSession session = request.getSession(false);
//			if(session != null) {
//				session.invalidate();
//			}
//			session = request.getSession(true);
//			session.setAttribute("username", username);
//			
//			response.sendRedirect("Deltakerliste");
//		}else {
//			
//			response.sendRedirect("Login" + "?invalidInput");
//		}
		
	}

}
