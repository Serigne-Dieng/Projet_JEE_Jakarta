package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.User;

public class UserDao {

	// Méthode pour lister tous les utilisateurs
	public static ArrayList<User> lister() {
		ArrayList<User> ListUtilisateurs = new ArrayList<User>();

		try (Statement statement = ConnexionDb.getConnection();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM users")) {

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String nom = resultSet.getString("nom");
				String prenom = resultSet.getString("prenom");
				String login = resultSet.getString("login");
				String password = resultSet.getString("password");

				User utilisateur = new User(id, nom, prenom, login, password);
				ListUtilisateurs.add(utilisateur);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ListUtilisateurs;
	}

	// Méthode pour ajouter un nouvel utilisateur
	public static void ajouter(User utilisateur) {
		try (Statement statement = ConnexionDb.getConnection()) {
			String query = String.format(
					"INSERT INTO users (nom, prenom, login, password) VALUES ('%s', '%s', '%s', '%s')",
					utilisateur.getNom(), utilisateur.getPrenom(), utilisateur.getLogin(), utilisateur.getPassword());
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Méthode pour modifier les informations d'un utilisateur existant
	public static void modifier(User utilisateur) {
		try (Statement statement = ConnexionDb.getConnection()) {
			String query = String.format(
					"UPDATE users SET nom='%s', prenom='%s', login='%s', password='%s' WHERE id=%d",
					utilisateur.getNom(), utilisateur.getPrenom(), utilisateur.getLogin(), utilisateur.getPassword(),
					utilisateur.getId());
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Méthode pour supprimer un utilisateur
	public static void supprimer(int userId) {
		try (Statement statement = ConnexionDb.getConnection()) {
			String query = String.format("DELETE FROM users WHERE id=%d", userId);
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Méthode pour récupérer un utilisateur par son ID
	public static User getUser(int userId) {
		User utilisateur = null;
		try (Statement statement = ConnexionDb.getConnection();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE id=" + userId)) {

			if (resultSet.next()) {
				String nom = resultSet.getString("nom");
				String prenom = resultSet.getString("prenom");
				String login = resultSet.getString("login");
				String password = resultSet.getString("password");

				utilisateur = new User(userId, nom, prenom, login, password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}
}
