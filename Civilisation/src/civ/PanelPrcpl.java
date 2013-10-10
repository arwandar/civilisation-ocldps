package civ;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;

import Batiment.BatMur;

public class PanelPrcpl extends JPanel {
	/*
	 * Panel où et affiché la map interactive, les unités... Il contient un gros
	 * tableau de boutons
	 */

	// **********VARIABLES
	private Case[][] carte;
	private int nbrCaseLarge, nbrCaseHauteur;
	JScrollPane jsp;
	JPanel conteneur;

	// **********CONSTRUCTEURS
	public PanelPrcpl(int largeur, int hauteur) {
		this.nbrCaseHauteur = 30;
		this.nbrCaseLarge = 60;
		this.carte = new Case[nbrCaseHauteur][nbrCaseLarge];

		this.conteneur = new JPanel();
		this.conteneur.setLayout(new GridLayout(nbrCaseHauteur, nbrCaseLarge));
		this.conteneur.setPreferredSize(new Dimension(nbrCaseLarge * 30, nbrCaseHauteur * 30));

		genererCarte(1);

		this.jsp = new JScrollPane(this.conteneur);
		this.jsp.setPreferredSize(new Dimension(largeur, hauteur - (40 * hauteur / 100)));
		
		int[] v={10,10};
		
		
		
		this.add(jsp);
	}

	// **********MUTATEURS

	public Case getCarte(int i, int j) {
		if (i < this.nbrCaseHauteur && j < this.nbrCaseLarge) {
			return carte[i][j];
		} else {
			System.out.println("erreur, tu essaies de retourner "+i+"/"+j);
			return null;
		}
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

	private void genererCarte() {
		for (int i = 0; i < this.nbrCaseHauteur; i++) {
			for (int j = 0; j < this.nbrCaseLarge; j++) {
				this.carte[i][j] = new Case();
				this.conteneur.add(this.carte[i][j]);
			}
		}
	}

	private void genererCarte(int numCarte) {
		if (numCarte == 1) {
			String plan = "333333333333333333333333333333333333333333333333333333333333322222222222222222222222222222222222222222222221111333333333322222222222222222222222222222222222222222222221111333333333322222222222222222222222222222222222222222222221111333333333322222222222222222222222222222222222222222222221111333333333322222222222222222222222222222222222222222222221111333333333322222222222222222222222222222222222222222222221111333333333322222222222222222222222222222222222222222222221111333333333322222244444444444444442222222222222222222222221111111111113322222244444444444444442222222222222222222222222111111111113322222244444440002222222222222222222222222222222111111111113322222244444440002222222222222222222222222222222222222222223322222244444440002222222222222222222222222222222222222222223322222244444440002222222222222222222222222222222222222222223322222244444444444444444444444444444222222222222222222222223322222244444444444444444444444444444222222222222222222222223322222244444444444444444444444444444222222222222222222222223322222244444444444444444444444444444222222222222222222222223322222244444444444444444444444444444222222222222222222222223322222244444444444444444444444444444222222222222222222222223322222244444444444444444444444444444222222222222222222222223322222244444444444444444444444444444222222222222222222222223322222244444444444444444444444444444222222222222222222222223322222222222222222222222222222222222222222222222222222222223322222222222222222222222222222222222222222222222222222222223322222222222222222222222222222222222222222222222222222222223322222222222222222222222222222222222222222222222222222222223322222222222222222222222222222222222222222222222222222222223322222222222222222222222222222222222222222222222222222222223333333333333333333333333333333333333333333333333333333333333";
			int a;
			for (int i = 0; i < this.nbrCaseHauteur; i++) {
				for (int j = 0; j < this.nbrCaseLarge; j++) {
					a = i * this.nbrCaseLarge + j;
					if (plan.charAt(a) == '0') {
						this.carte[i][j] = new Case(Texture.montagne);
					} else if (plan.charAt(a) == '1') {
						this.carte[i][j] = new Case(Texture.sable);
					} else if (plan.charAt(a) == '2') {
						this.carte[i][j] = new Case(Texture.terre);
					} else if (plan.charAt(a) == '3') {
						this.carte[i][j] = new Case(Texture.eau);
					} else if (plan.charAt(a) == '4') {
						this.carte[i][j] = new Case(Texture.foret);
					} else {
						this.carte[i][j] = new Case(Texture.nondefini);
					}
					this.carte[i][j].setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

					this.conteneur.add(this.carte[i][j]);
				}
			}
		} else {
			genererCarte();

		}
	}
}
