package servlets;

import java.io.IOException;
import java.util.ArrayList;

import bean.User;
import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "", "/users", "/list" })
@SuppressWarnings("serial")
public class ControllerUser extends HttpServlet {
	private static final String VUE_LISTUSER = "/WEB-INF/userView.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ArrayList<User> utilisateurs = UserDao.lister();
		req.setAttribute("utilisateurs", utilisateurs);
		req.getRequestDispatcher(VUE_LISTUSER).forward(req, resp);

	}
}
