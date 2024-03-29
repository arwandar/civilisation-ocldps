package civ;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import Unites.Personnage;
import Batiment.BatProdRes;
import Batiment.Batiment;

public class PanelPrcpl extends JPanel implements ActionListener {
	/*
	 * Panel o� et affich� la map interactive, les unit�s... Il contient un gros
	 * tableau de boutons
	 */

	// **********VARIABLES
	private Case[][] carte;
	private int nbrCaseLarge, nbrCaseHauteur;
	JScrollPane jsp;
	JPanel conteneur;
	FntPrcpl saFenetre;
	private String plan1 = "333333333333333333333333333333333333333333333333333333333333322222222222222222222222222222222222222222222221111333333333322222222222222222222222222222222222222222222221111333333333322222222222222222222222222222222222222222222221111333333333322222222222222222222222222222222222222222222221111333333333322222222222222222222222222222222222222222222221111333333333322222222222222222222222222222222222222222222221111333333333322222222222222222222222222222222222222222222221111333333333322222244444444444444442222222222222222222222221111111111113322222244444444444444442222222222222222222222222111111111113322222244444440002222222222222222222222222222222111111111113322222244444440002222222222222222222222222222222222222222223322222244444440002222222222222222222222222222222222222222223322222244444440002222222222222222222222222222222222222222223322222244444444444444444444444444444222222222222222222222223322222244444444444444444444444444444222222222222222222222223322222244444444444444444444444444444222222222222222222222223322222244444444444444444444444444444222222222222222222222223322222244444444444444444444444444444222222222222222222222223322222244444444444444444444444444444222222222222222222222223322222244444444444444444444444444444222222222222222222222223322222244444444444444444444444444444222222222222222222222223322222244444444444444444444444444444222222222222222222222223322222222222222222222222222222222222222222222222222222222223322222222222222222222222222222222222222222222222222222222223322222222222222222222222222222222222222222222222222222222223322222222222222222222222222222222222222222222222222222222223322222222222222222222222222222222222222222222222222222222223322222222222222222222222222222222222222222222222222222222223333333333333333333333333333333333333333333333333333333333333";
	int numPlan;

	// **********CONSTRUCTEURS
	public PanelPrcpl(int largeur, int hauteur, FntPrcpl fnt) {
		this.saFenetre = fnt;
		this.numPlan = 1; // choix de la carte
		this.nbrCaseHauteur = 30;
		this.nbrCaseLarge = 60;
		this.carte = new Case[nbrCaseHauteur][nbrCaseLarge];

		this.conteneur = new JPanel();
		this.conteneur.setLayout(new GridLayout(nbrCaseHauteur, nbrCaseLarge));
		this.conteneur.setPreferredSize(new Dimension(nbrCaseLarge * 30, nbrCaseHauteur * 30));

		genererCarte();
		updateCarte();

		this.setBounds(0, 50, largeur, hauteur - 50 - (30 * hauteur / 100));

		this.jsp = new JScrollPane(this.conteneur);
		this.jsp.setPreferredSize(new Dimension(this.getWidth(), getHeight()));

		this.add(jsp);

	}

	// **********MUTATEURS

	public Case getCarte(int i, int j) {
		if (i < this.nbrCaseHauteur && j < this.nbrCaseLarge) {
			return carte[i][j];
		} else {
			System.out.println("erreur, tu essaies de retourner " + i + "/" + j);
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
		if (this.numPlan == 1) {
			int a;
			for (int i = 0; i < this.nbrCaseHauteur; i++) {
				for (int j = 0; j < this.nbrCaseLarge; j++) {
					a = i * this.nbrCaseLarge + j;
					if (plan1.charAt(a) == '0') {
						this.carte[i][j] = new Case(Texture.montagne);
					} else if (plan1.charAt(a) == '1') {
						this.carte[i][j] = new Case(Texture.sable);
					} else if (plan1.charAt(a) == '2') {
						this.carte[i][j] = new Case(Texture.terre);
					} else if (plan1.charAt(a) == '3') {
						this.carte[i][j] = new Case(Texture.eau);
					} else if (plan1.charAt(a) == '4') {
						this.carte[i][j] = new Case(Texture.foret);
					} else {
						this.carte[i][j] = new Case(Texture.nondefini);
					}
					this.carte[i][j].setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
					this.carte[i][j].addActionListener(this);
					this.conteneur.add(this.carte[i][j]);
				}
			}
		}
	}

	protected void updateCarte() {
		for (int i = 0; i < this.nbrCaseHauteur; i++) {
			for (int j = 0; j < this.nbrCaseLarge; j++) {
				this.carte[i][j].setBackground();
				this.carte[i][j].setText(null);
				this.carte[i][j].setToolTipText(null);
				this.carte[i][j].setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
			}
		}
		for (int k = 0; k < this.saFenetre.lesJoueurs.length; k++) {
			ArrayList<Batiment> batiments = this.saFenetre.lesJoueurs[k].getBatiments();
			ArrayList<Personnage> personnages = this.saFenetre.lesJoueurs[k].getPersonnages();
			Border border = new LineBorder(this.saFenetre.lesJoueurs[k].getSaCouleur(), 3);
			if (!batiments.isEmpty()) {
				Iterator<Batiment> itbat = batiments.iterator();
				while (itbat.hasNext()) {
					Batiment bat = itbat.next();
					this.carte[bat.getPOSITION(1)][bat.getPOSITION(0)].setBackground(this.saFenetre.lesJoueurs[k].getSaCouleur());
					this.carte[bat.getPOSITION(1)][bat.getPOSITION(0)].setText(bat.getNOM());
					if (bat.getNOM() != "mine") {
						this.carte[bat.getPOSITION(1)][bat.getPOSITION(0)].setToolTipText(bat.getNOM());
					} else {
						BatProdRes hello = (BatProdRes) bat;
						this.carte[bat.getPOSITION(1)][bat.getPOSITION(0)].setToolTipText(bat.getNOM() + " " + hello.getRESSOURCE().toString());
					}
				}
			}
			if (!personnages.isEmpty()) {
				Iterator<Personnage> itperso = personnages.iterator();
				while (itperso.hasNext()) {
					Personnage perso = itperso.next();
					this.carte[perso.getPositionVerticale()][perso.getPositionHorizontale()].setBorder(border);
					this.carte[perso.getPositionVerticale()][perso.getPositionHorizontale()].setText(perso.getT().toString());
					this.carte[perso.getPositionVerticale()][perso.getPositionHorizontale()].setToolTipText(perso.getT().toString());
				}
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		boolean caseTrouvee = false;
		for (int i = 0; i < this.nbrCaseHauteur && caseTrouvee == false; i++) {
			for (int j = 0; j < this.nbrCaseLarge && caseTrouvee == false; j++) {
				if (this.carte[i][j] == e.getSource()) {
					caseTrouvee = true;

					this.saFenetre.barrebasse.updateActionPossible(this.carte[i][j], i, j);

					if (this.saFenetre.barrebasse.actionEnCours) {
						this.saFenetre.barrebasse.executerActionComplexe(i, j);
					}
				}
			}
		}
	}
}
