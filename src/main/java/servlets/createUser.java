package servlets;

import java.io.IOException;

import bean.User;
import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/adduser")
public class createUser extends HttpServlet {

	private static final String VUE_AJOUTER_UTILISATEUR = "/WEB-INF/addUserForm.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(VUE_AJOUTER_UTILISATEUR).forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Récupérer les paramètres du formulaire

		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		String login = req.getParameter("login");
		String password = req.getParameter("password");

		// Créer un nouvel utilisateur
		User nouvelUtilisateur = new User(nom, prenom, login, password);

		// Ajouter l'utilisateur à la liste
		UserDao.ajouter(nouvelUtilisateur);

		resp.sendRedirect(req.getContextPath() + "/users");
	}
}