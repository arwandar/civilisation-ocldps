package civ;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanelPrcpl extends JPanel {
	/*
	 * Panel où et affiché la map interactive, les unités... Il contient un gros
	 * taleau de boutons
	 */

	// **********VARIABLES
	private Case[][] carte;
	private int nbrCaseLarge, nbrCaseHauteur;
	JScrollPane jsp;
	JPanel conteneur;

	// **********CONSTRUCTEURS
	public PanelPrcpl() {
		this.nbrCaseHauteur = 10;
		this.nbrCaseLarge = 15;
		this.carte = new Case[nbrCaseHauteur][nbrCaseLarge];

		this.conteneur = new JPanel();

		this.conteneur.setLayout(new GridLayout(nbrCaseHauteur, nbrCaseLarge));
		this.conteneur.setPreferredSize(new Dimension(nbrCaseLarge * 50, nbrCaseHauteur * 50));

		for (int i = 0; i < this.nbrCaseHauteur; i++) {
			for (int j = 0; j < this.nbrCaseLarge; j++) {
				this.carte[i][j] = new Case();
				this.conteneur.add(this.carte[i][j]);
			}
		}

		this.jsp = new JScrollPane(this.conteneur);
		this.jsp.setPreferredSize(new Dimension(FntPrcpl.largeur, FntPrcpl.hauteur - (40 * FntPrcpl.hauteur / 100)));
		this.add(jsp);
	}

	// **********MUTATEURS

	public Case getCarte(int i, int j) {
		return carte[i][j];
	}

	public void setCarte(Case bouh, int i, int j) {
		this.carte[i][j] = bouh;
	}

	public int getNbrCaseLarge() {
		return nbrCaseLarge;
	}

	public void setNbrCaseLarge(int nbrCaseLarge) {
		this.nbrCaseLarge = nbrCaseLarge;
	}

	public int getNbrCaseHauteur() {
		return nbrCaseHauteur;
	}

	public void setNbrCaseHauteur(int nbrCaseHauteur) {
		this.nbrCaseHauteur = nbrCaseHauteur;
	}

	public JPanel getConteneur() {
		return conteneur;
	}

	public void setConteneur(JPanel conteneur) {
		this.conteneur = conteneur;
	}

	// **********METHODES
}
