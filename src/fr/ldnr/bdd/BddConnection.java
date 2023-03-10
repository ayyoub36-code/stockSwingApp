/**
 * @author El babili - 2021
 * 
 */

package fr.ldnr.bdd;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class BddConnection {
	private static Connection connection;
	private static String driver;
	private static String url;
	private static String login;
	private static String password;

	//constructeur privé -> voir pattern Singleton
	private BddConnection() {
		try {
			getConfigFile();	//D'abord on ouvre le fichier de config pour alimenter nos attributs
								//rien à voir avec le pattern Singleton, c'est une sécurité + une facilité d'évolution ici
			try {
				Class.forName(driver);	//puis on charge le driver
				connection = DriverManager.getConnection(url,login,password);	//et on ouvre une connection
			}
			catch (ClassNotFoundException | SQLException e) {
				System.out.println("problème de connexion !" + e.getMessage());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Il faut générer le fichier de config avant de pouvoir l'utiliser !");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//m�thode qui retourne une connection, si inexistante, il l'a crée une seule fois
	public static Connection getConnection() {
		if(connection == null)	new BddConnection();
		return connection;
	}
	
	//méthode qui ouvre le fichier de config d'une connection
	private static void getConfigFile() throws FileNotFoundException, IOException {
		Properties props = new Properties();		
		try (FileInputStream fis = new FileInputStream("files/config.properties")){
			props.load(fis);
		} catch (FileNotFoundException e1) {
			System.out.println("Fichier de config non trouvé !" + e1.getMessage());
		} catch (IOException e1) {
			System.out.println("Erreur lecture fichier config ! " + e1.getMessage());
		}
		
		driver = props.getProperty("db.driver");
		url = props.getProperty("db.url");
		login = props.getProperty("db.login");
		password = props.getProperty("db.password");
	}
}
