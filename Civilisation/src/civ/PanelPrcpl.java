package civ;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.Scrollable;
import javax.swing.SwingConstants;

public class PanelPrcpl extends JPanel{
	/*
	 * Panel où et affiché la map interactive, les unités... Il contient un gros
	 * taleau de boutons
	 */

	// **********VARIABLES
	JButton[][] morceaux;
	int nbrCaseLarge, nbrCaseHauteur;
	JScrollPane jsp;
	JPanel conteneur;

	// **********CONSTRUCTEURS
	public PanelPrcpl() {
		this.nbrCaseHauteur = 10;
		this.nbrCaseLarge = 15;
		this.morceaux = new JButton[nbrCaseHauteur][nbrCaseLarge];
		
		this.conteneur = new JPanel();

		this.conteneur.setLayout(new GridLayout(nbrCaseHauteur, nbrCaseLarge));
		this.conteneur.setPreferredSize(new Dimension(nbrCaseLarge*50, nbrCaseHauteur*50));
		
		for (int i = 0; i < this.nbrCaseHauteur; i++) {
			for (int j = 0; j < this.nbrCaseLarge; j++) {
				this.morceaux[i][j] = new JButton();
				this.morceaux[i][j].setBackground(Color.white);
				this.conteneur.add(this.morceaux[i][j]);
			}
		}

		
		this.jsp = new JScrollPane(this.conteneur);
		this.jsp.setPreferredSize(new Dimension(FntPrcpl.largeur, FntPrcpl.hauteur - (40 * FntPrcpl.hauteur / 100)));
		this.add(jsp);
		System.out.println(this.conteneur.getPreferredSize().height+"/"+this.conteneur.getPreferredSize().width);
	}

	// **********MUTATEURS

	// **********METHODES
}
