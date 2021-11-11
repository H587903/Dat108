package Servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Database_stuff.Paameldte;
import Database_stuff.PaameldteDAO;



//@WebServlet("/Deltakerliste")
@WebServlet(name = "Deltakerliste", urlPatterns = "/Deltakerliste")
public class Deltakerliste extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private PaameldteDAO paameldteDAO;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession(false);
		
		if(session == null || session.getAttribute("mobil") == null) {
			response.sendRedirect("Login"  + "?invalidSession");
		} else {
			
			List<Paameldte> liste = paameldteDAO.visDeltakerListe();
			if(liste != null) {
				session.setAttribute("Paameldte", liste);
			}
			request.getRequestDispatcher("WEB-INF/jsp/deltagerliste.jsp").forward(request, response);
		}
	}
}
