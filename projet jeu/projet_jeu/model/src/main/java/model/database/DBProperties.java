package model.database;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * La classe DBProperties.
 */
class DBProperties extends Properties {

	/**
	 * Constante contenant le nom du fichier des propriétés
	 */
	private final static String	PROPERTIES_FILE_NAME	= "model.properties";

	/**
	 * L'URL de la base
	 */
	private String		url										;

	/**
	 * Nom d'utilisateur
	 */
	private String		login									;

	/**
	 * Mot de passe
	 */
	private String		password							;

	/**
	 * Instancie la classe
	 */
	public DBProperties() {
		InputStream inputStream;

		inputStream = this.getClass().getClassLoader().getResourceAsStream(DBProperties.PROPERTIES_FILE_NAME);

		if (inputStream != null) {
			try {
				this.load(inputStream);
			} catch (final IOException e) {
				e.printStackTrace();
			}
			this.setUrl(this.getProperty("url"));
			this.setLogin(this.getProperty("login"));
			this.setPassword(this.getProperty("password"));
		}
	}

	/**
	 * Getter pour l'url
	 * @return String
	 * L'URL
	 */
	public String getUrl() {
		return this.url;
	}

	/**
	 * Setter pour l'url
	 * @param url
	 * La nouvelle URL
	 */
	private void setUrl(final String url) {
		this.url = url;
	}

	/**
	 * Getter pour le login
	 * @return String
	 * Le Login
	 */
	public String getLogin() {
		return this.login;
	}

	/**
	 * Setter pour le login
	 * @param login
	 *  Le nouveau login
	 */
	private void setLogin(final String login) {
		this.login = login;
	}

	/**
	 * Getter pour le password
	 * @return String
	 * Le password
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Setter pour le password
	 * @param password
	 * Le nouveau password
	 */
	private void setPassword(final String password) {
		this.password = password;
	}

}
