package civ;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelPrcpl extends JPanel {
	/*
	 * Panel où et affiché la map interactive, les unités... Il contient un gros
	 * taleau de boutons
	 */

	// **********VARIABLES
	JButton[][] morceaux;
	int nbrCaseLarge, nbrCaseHauteur;

	// **********CONSTRUCTEURS
	public PanelPrcpl() {
		this.nbrCaseHauteur = 4;
		this.nbrCaseLarge = 3;
		this.morceaux = new JButton[nbrCaseHauteur][nbrCaseLarge];
		//this.setPreferredSize(new Dimension(20, 50));
		
		this.setLayout(new GridLayout(nbrCaseHauteur, nbrCaseLarge));

		for (int i = 0; i < this.nbrCaseHauteur; i++) {
			for (int j = 0; j < this.nbrCaseLarge; j++) {
				this.morceaux[i][j]= new JButton();
				this.morceaux[i][j].setBackground(Color.white);
				//this.morceaux[i][j].setPreferredSize(new Dimension(100, 100));
				this.add(this.morceaux[i][j]);
				
			}
		}
	}

	// **********MUTATEURS

	// **********METHODES
}
