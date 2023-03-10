package fr.ldnr;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import fr.ldnr.bdd.ProductDao;
import fr.ldnr.entities.Product;

import fr.ldnr.mvc.Controller;
import fr.ldnr.mvc.Model;
import fr.ldnr.mvc.View;
//import fr.ldnr.hmi.Controller;
//import fr.ldnr.hmi.Model;
//import fr.ldnr.hmi.View;

/**
 * App de gestion de stock qui affiche l'ensemble des produits en base par simple clic sur le bouton / voir le script Store.sql dans le dossier files
 * C'est une Appli Desktop utilisant Swing et le pattern MVC 
 * La partie BDD utilise les patterns Singleton et Dao + utilisation d'un fichier de configuration config.properties 
 * 
 * Il existe 2 versions de l'utilisation du modèle MVC dont une simplifiée(voir le packge fr.ldnr.hmi) et une complète dans fr.ldnr.mvc
 * Les 2 versions contiennent respectivement les classes Model, View, Controller aussi pour tester les 2 versions, il faut juste changer les imports
 * Voir explication complémentaire entre commentaire 
 * 
 * @author El babili - 2021
 * 
 */

public class App {
	
	public static void main(String[] args) {	//Mise en oeuvre du pattern MVC		
		try {
			UIManager.setLookAndFeel( new NimbusLookAndFeel() );
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		// instanciation du model qui accède à la couche bdd afin de récupérer la liste des produits qu'il espère afficher dans une JTextArea ou JTable de la vue
		// dans le cas d'une JTable, le model doit hériter de la classe AbstractTableModel et redéfinir les méthodes de celle-ci permettant de gérer automatiquement l'affichage des datas
		// lorsque la view reçoit l'ordre de se raffraichir par le controleur à condition que celui-ci ait établi un lien entre eux (model et view)
		Model model = new Model();		
		
		// Instanciation de la view qui construit l'IHM entièrement
		View view = new View();			
		
		// le controleur associe la vue au model en appelant une méthode dans la vue contenant l'instruction suivante : new JTable(model)
		// en effet, chaque fois que l'usr via la view souhaite afficher le contenu de la table en cliquant sur le bouton
		// le controller alerte le model qui doit charger les datas en base puis raffraichit la vue avec les datas même si elles sont identiques		
		new Controller(model, view);	
		
		//testProductDao();			
	}

	private static void testProductDao() {
		for(Product p : new ProductDao().readAll())
		System.out.println(p);		
	}
}
