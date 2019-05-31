package dev.sgp.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class EditerCollaborateursController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String matriculeParam = req.getParameter("matricule");
		if(matriculeParam == null) {
			resp.sendError(400, "Un matricule est attendu");
		} else {
			resp.setStatus(200);
			resp.setContentType("text/html");
			String html = "<h1>Edition de collaborateur</h1>"
					+ "<p>Matricule : " + matriculeParam + "</p>";
			resp.getWriter().write(html);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String matriculeParam = req.getParameter("matricule");
		String titreParam = req.getParameter("titre");
		String nomParam = req.getParameter("nom");
		String prenomParam = req.getParameter("prenom");
		if(matriculeParam == null || titreParam == null || nomParam == null || prenomParam == null) {
			String error = "Les paramètres suivants sont incorrects : ";
			if(matriculeParam == null) {
				error += "matricule ";
			}
			if(titreParam == null) {
				error += "titre ";
			}
			if(nomParam == null) {
				error += "nom ";
			}
			if(prenomParam == null) {
				error += "prenom ";
			}
			resp.sendError(400, error);
		} else {
			resp.setStatus(201);
			resp.setContentType("text/html");
			resp.getWriter().write("<p>Création d'un collaborateur avec les informations suivantes : "
					+ "matricule=" + matriculeParam + ",titre=" + titreParam + ",nom=" + nomParam + ",prenom=" + prenomParam + "</p>");
		}
	}
}
