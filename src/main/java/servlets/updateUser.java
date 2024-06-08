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
@WebServlet("/update")
public class updateUser extends HttpServlet {

	private static final String VUE_UPDATE_UTILISATEUR = "/WEB-INF/updateUser.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int userId = Integer.parseInt(req.getParameter("id"));
		User user = UserDao.getUser(userId);
		req.setAttribute("user", user);
		req.getRequestDispatcher(VUE_UPDATE_UTILISATEUR).forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Si l'action est "update", mettre à jour l'utilisateur
		int userId = Integer.parseInt(req.getParameter("id"));
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		String login = req.getParameter("login");
		String password = req.getParameter("password");

		// Créer un nouvel utilisateur avec les données mises à jour
		User utilisateurMisAJour = new User(userId, nom, prenom, login, password);

		// Appeler la méthode de mise à jour dans userDao
		UserDao.modifier(utilisateurMisAJour);
		resp.sendRedirect(req.getContextPath() + "/users");
	}
}