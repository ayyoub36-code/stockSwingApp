package fr.ldnr.hmi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
	private Model model;
	private View view;
	
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
		initController();

	}
	public void initController(){
		view.getOk().addActionListener(this);	// association du bouton ok avec l'action souhaitée par le controleur	
	}
	
	private void actionChangeHMI() {
		model.loadData();										// chargement des données en base dans le modèle
		view.getTxtaProducts().setText(model.getProducts());	// affichage des données sur la vue
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		actionChangeHMI();		
	}
}

