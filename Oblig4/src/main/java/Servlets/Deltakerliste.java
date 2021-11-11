package Servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



//@WebServlet("/Deltakerliste")
@WebServlet(name = "Deltakerliste", urlPatterns = "/Deltakerliste")
public class Deltakerliste extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession(false);
		
		if(session == null || session.getAttribute("username") == null) {
			response.sendRedirect("Login"  + "?invalidSession");
		} else {
			request.getRequestDispatcher("WEB-INF/jsp/deltagerliste.jsp").forward(request, response);
		}
	}
}
