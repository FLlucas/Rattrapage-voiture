package model.database;

import java.lang.String;
import java.sql.*;
import java.sql.SQLException;


/**
 * La classe DBConnection.
 */
public final class DBConnection {
	/**
	 * L'instance unique du pattern Singleton
	 */
	private static DBConnection	INSTANCE = null;

	/**
	 * La connection
	 */
	private Connection	connection;

	/**
	 * Instancier une connection
	 */
	private DBConnection() {
		this.open();
	}

	/**
	 * Enregistrer le score dans la BD
	 * @param score
	 * Le score
	 * @throws SQLException
	 * Reporter l'erreur
	 */
	public void saveScore(int score) throws SQLException{
		final String sql = "{CALL addScore("+score+")}";
		final CallableStatement call = this.getConnection().prepareCall(sql);
		call.execute();
	}


	/**
	 * Obtenir l'instance unique de la connection
	 * @return DBConnection
	 * L'instance de connection
	 */
	public static synchronized DBConnection getInstance() {
		if (DBConnection.INSTANCE == null) {
			DBConnection.INSTANCE = new DBConnection();
		}
		return DBConnection.INSTANCE;
	}

	/**
	 * Ouvrir la connection
	 * @return boolean
	 */
	private Boolean open() {
		final DBProperties dbProperties = new DBProperties();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(dbProperties.getUrl(), dbProperties.getLogin(), dbProperties.getPassword());
		} catch (final ClassNotFoundException e) {
			e.printStackTrace();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * Getter pour la connection.
	 * @return Connection
	 * La connection
	 */
	public Connection getConnection() {
		return this.connection;
	}


}
