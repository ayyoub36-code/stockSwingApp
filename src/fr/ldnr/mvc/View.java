package fr.ldnr.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import fr.ldnr.entities.Product;

public class View extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton ok = new JButton("charger la table des produits");
	private JScrollPane jScrollPane;
	private JTable jtable;
	
	private static final int WIDTH = 75;	//largeur
	private static final int HEIGHT = 25;	//hauteur	
	
	private JTextField txtDescription;	
	private JTextField txtBrand;
	private JTextField txtPrice;
	private JTextField txtCategory;
	private JTextField txtQuantity;
	private JButton add = new JButton("Ajouter");

	public View() {
		super("Mon appli de gestion de stock");		
		initView();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 350);
		setLocationRelativeTo(null);
		setVisible(true);		
	}

	public void initView() {
		this.setLayout(new BorderLayout());
		JPanel panelNorth = new JPanel();
		panelNorth.setLayout(new FlowLayout());
		panelNorth.add(ok);
		this.add(panelNorth,BorderLayout.NORTH);		
		//la vue construit tous les éléments graphiques mais laisse le controller se charger de l'action à mener en sollicitant le model
		initSouth();
	}
	
	public void initSouth() {
		JPanel panelSouth = new JPanel();
		panelSouth.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JLabel lblDescription = new JLabel("Description", SwingConstants.RIGHT);
		lblDescription.setPreferredSize(new Dimension(WIDTH , HEIGHT));
	    panelSouth.add(lblDescription);
		txtDescription = new JTextField();
		txtDescription.setPreferredSize(new Dimension(WIDTH , HEIGHT));
		panelSouth.add(txtDescription);
		
		JLabel lblBrand = new JLabel("Marque", SwingConstants.RIGHT);
		lblBrand.setPreferredSize(new Dimension(WIDTH , HEIGHT));
		panelSouth.add(lblBrand);
		txtBrand = new JTextField();
		txtBrand.setPreferredSize(new Dimension(WIDTH , HEIGHT));
		panelSouth.add(txtBrand);
		
		JLabel lblPrice = new JLabel("Prix", SwingConstants.RIGHT);
		lblPrice.setPreferredSize(new Dimension(WIDTH , HEIGHT));
		panelSouth.add(lblPrice);
		txtPrice = new JTextField();
		txtPrice.setPreferredSize(new Dimension(WIDTH , HEIGHT));
		panelSouth.add(txtPrice);	
		
		JLabel lblCategory = new JLabel("Category", SwingConstants.RIGHT);
		lblCategory.setPreferredSize(new Dimension(WIDTH , HEIGHT));
		panelSouth.add(lblCategory);
		txtCategory = new JTextField();
		txtCategory.setPreferredSize(new Dimension(WIDTH , HEIGHT));
		panelSouth.add(txtCategory);	
		
		JLabel lblQuantity = new JLabel("Quantity", SwingConstants.RIGHT);
		lblQuantity.setPreferredSize(new Dimension(WIDTH , HEIGHT));
		panelSouth.add(lblQuantity);
		txtQuantity = new JTextField();
		txtQuantity.setPreferredSize(new Dimension(WIDTH , HEIGHT));
		panelSouth.add(txtQuantity);
		
		panelSouth.add(add);
		
		this.getContentPane().add(panelSouth , BorderLayout.SOUTH);
	}
	
	public static void warning(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Attention", JOptionPane.WARNING_MESSAGE);
	}
	
	public void initTable(Model model) {
		setJtable(new JTable(model));						// association de la table de la vue avec le model 
		setjScrollPane(new JScrollPane(getJtable())); 		// association de la barre de défilement avec la table
		add(getjScrollPane(),BorderLayout.CENTER);			// insertion de la barre (contenant le tableau) dans la vue
		setVisible(true);		
	}
	
	public Product getProduct() {
		return new Product(txtDescription.getText(), txtBrand.getText(), Double.valueOf(txtPrice.getText()), 
				txtCategory.getText(), Integer.valueOf(txtQuantity.getText()));
	}
	
	public JButton getOk() {
		return ok;
	}

	public void setOk(JButton ok) {
		this.ok = ok;
	}

	public JButton getAdd() {
		return add;
	}

	public void setAdd(JButton add) {
		this.add = add;
	}

	public JTable getJtable() {
		return jtable;
	}

	public void setJtable(JTable jtable) {
		this.jtable = jtable;
	}
	public JScrollPane getjScrollPane() {
		return jScrollPane;
	}

	public void setjScrollPane(JScrollPane jScrollPane) {
		this.jScrollPane = jScrollPane;
	}

	public void setProduct() {
		txtDescription.setText("");
		txtBrand.setText("");
		txtPrice.setText("");
		txtCategory.setText("");
		txtQuantity.setText("");	
	}
}
