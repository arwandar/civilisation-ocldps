package civ;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelBas extends JPanel {
	/*
	 * Panel qui servira à afficher la map, les stats du trucs selectionnés, les
	 * actions réalisbles
	 */

	// **********VARIABLES
	JPanel map, info, panelActionsPossibles;

	// **********CONSTRUCTEURS
	public PanelBas() {
		this.setLayout(null);
		int hauteur = FntPrcpl.hauteur;
		int largeur = FntPrcpl.largeur;
		this.setBounds(0, (hauteur - (30 * hauteur / 100)), largeur, (30 * hauteur / 100));
		
		
		JButton test1 = new JButton();
		test1.setBounds(0, 0, this.getWidth(), this.getHeight());
		
		this.add(test1);


	}
	// **********MUTATEURS

	// **********METHODES
}
