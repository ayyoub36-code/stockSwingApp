package fr.ldnr.mvc;

import fr.ldnr.bdd.ProductDao;
import fr.ldnr.entities.Product;

public class Controller {
	private Model model;
	private View view;
	
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
		initController();

	}
	public void initController(){
		view.initTable(model);		// initialisation du tableau dans la vue, gérée par le model
		view.getOk().addActionListener(e -> actionChangeHMI());	// association du bouton ok avec l'action souhaitée par le controleur	
		view.getAdd().addActionListener(e -> actionAddProduct());
	}
	
	private void actionAddProduct() {
		Product product = view.getProduct();
		model.addProduct(product);
		actionChangeHMI();
		view.setProduct();
	}
	
	private void actionChangeHMI() {
		//on pourrait imaginer ici un controle de droit d'accés avant de permettre telle action
		try {
			model.loadData();				// chargement des données en base dans le modèle
			model.fireTableChanged(null);	// signalement d'un changement à la vue qui doit se raffraichir
		}
		catch(Exception e) {
			View.warning(" Oups il y a eu un pb : " + e.getMessage());
		}
	}
}


/*	view.getOk().addActionListener(new ActionListener() {			
@Override
public void actionPerformed(ActionEvent e) {
	model.loadData();				
}
});		*/