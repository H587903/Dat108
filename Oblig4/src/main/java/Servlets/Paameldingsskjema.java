package Servlets;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Hjelpeklasser.Skjema;


//@WebServlet("/Paameldingsskjema")
@WebServlet(name = "Paameldingsskjema", urlPatterns = "/Paameldingsskjema")
public class Paameldingsskjema extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("WEB-INF/jsp/paameldingsskjema.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Skjema skjema = new Skjema(request);

		if (skjema.isAllInputGyldig()) {
			String username = request.getParameter("mobil");

			HttpSession session = request.getSession(false);
			if (session != null) {
				session.invalidate();
			}
			session = request.getSession(true);
			session.setAttribute("username", username);

			response.sendRedirect("Paameldingsbekreftelse");
		} else {
			
			skjema.feilmeldinger();
			
			request.getSession().setAttribute("Paameldingsskjema", skjema);
			response.sendRedirect("Paameldingsskjema");
		}
		
		
	}

}
