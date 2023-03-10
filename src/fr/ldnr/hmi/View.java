package fr.ldnr.hmi;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class View extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton ok = new JButton("charger la table des produits");
	private JScrollPane jScrollPane;
	private JTextArea txtaProducts;

	public View() {
		super("Mon appli de gestion de stock");				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 300);
		setLocationRelativeTo(null);
		initView();
		
		txtaProducts = new JTextArea();
		txtaProducts.setEditable(false);
		jScrollPane = new JScrollPane(txtaProducts);		
		jScrollPane.setPreferredSize(new Dimension(250,250));
		add(getjScrollPane(),BorderLayout.CENTER);					
		setVisible(true);		
	}
	
	public static void warning(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Attention", JOptionPane.WARNING_MESSAGE);
	}

	public void initView() {
		this.setLayout(new BorderLayout());
		JPanel panelNorth = new JPanel();
		panelNorth.setLayout(new FlowLayout());
		panelNorth.add(ok);
		this.add(panelNorth,BorderLayout.NORTH);		
		//la vue construit tous les éléments graphiques mais laisse le controller se charger de l'action à mener en sollicitant le model
	}
	
	public JTextArea getTxtaProducts() {
		return txtaProducts;
	}

	public void setTxtaProducts(JTextArea txtaProducts) {
		this.txtaProducts = txtaProducts;
	}

	public JButton getOk() {
		return ok;
	}

	public void setOk(JButton ok) {
		this.ok = ok;
	}

	public JScrollPane getjScrollPane() {
		return jScrollPane;
	}

	public void setjScrollPane(JScrollPane jScrollPane) {
		this.jScrollPane = jScrollPane;
	}
}
