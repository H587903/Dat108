package Servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Database_stuff.Paameldte;
import Database_stuff.PaameldteDAO;
import Hjelpeklasser.Skjema;

//@WebServlet("/Paameldingsskjema")
@WebServlet(name = "Paameldingsskjema", urlPatterns = "/Paameldingsskjema")
public class Paameldingsskjema extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private PaameldteDAO paameldteDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//request.getRequestDispatcher("WEB-INF/jsp/paameldingsskjema.jsp").forward(request, response); //Påmeldingsskjema med validasjon på tjenerside
		request.getRequestDispatcher("WEB-INF/jsp/paameldingsskjema2.jsp").forward(request, response); //Påmeldingsskjema2 med validasjon på klientside
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Skjema skjema = new Skjema(request);

		
		if (skjema.isAllInputGyldig()) { // Succsessful påmelding
			
			if (paameldteDAO.sjekkMobilFinst(skjema.getMobil())) { 	//Sjekke om mobil allerede er registrert når all input er gyldig
				skjema.feilmeldinger();
				skjema.setMobilFeil("Mobilnummer er allerede registrert.");

				request.getSession().setAttribute("Paameldingsskjema", skjema);
				response.sendRedirect("Paameldingsskjema");	//redirect tilbake med feilmeldinger om mobil allerede er registrert
				return;
			}

			Paameldte paameldte = new Paameldte(request); // Hentar verdi frå validerte inputfelt
			paameldteDAO.skrivTilDatabase(paameldte); // Tar verdiane og skriv til database

			HttpSession session = request.getSession(false);
			if (session != null) {
				session.invalidate();
			}
			session = request.getSession(true);
			session.setAttribute("mobil", skjema.getMobil());
			session.setAttribute("fornavn", skjema.getFornavn());
			session.setAttribute("etternavn", skjema.getEtternavn());
			session.setAttribute("kjonn", skjema.getKjonn());

			response.sendRedirect("Paameldingsbekreftelse");

		} else { // Unsuccessful påmelding

			skjema.feilmeldinger();

			request.getSession().setAttribute("Paameldingsskjema", skjema);
			response.sendRedirect("Paameldingsskjema");
		}

	}

}
