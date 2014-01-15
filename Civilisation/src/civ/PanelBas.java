package civ;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Unites.Personnage;
import joueur.Joueur;
import Batiment.Batiment;

public class PanelBas extends JPanel {
	/*
	 * Panel qui servira � afficher la panelMap, les stats du trucs
	 * selectionn�s, les actions r�alisbles
	 */

	// **********VARIABLES
	private JPanel panelMap, panelActionsPossibles, panelInterne;
	private FntPrcpl saFenetre;
	private JButton[][] map;
	private int mapLargeur, mapHauteur;
	JTextArea infoText;
	CardLayout cl;
	String[] enumCl = {"Archerie", "atelier de si�ge", "Caserne", "Ecurie", "Hotel de ville", "Mur", "Port", "mine", "Tour des mages", "Tourelle","casevide" };
	JPanel[] jcard;
	JButton[] actionPossible;

	// **********CONSTRUCTEURS
	public PanelBas(int hauteur, int largeur, FntPrcpl bouh) {
		this.saFenetre = bouh;
		this.setLayout(null);
		this.setBounds(0, (hauteur - (30 * hauteur / 100)), largeur, (30 * hauteur / 100));

		// init panelmap
		creerMap();
		this.add(this.panelMap);
		
		// init la jtext d'info
		this.infoText = new JTextArea();
		this.infoText.setBounds(this.getWidth() * 4 / 5, 0, this.getWidth() / 5, this.getHeight());
		this.add(this.infoText);

		// init panelactionpossibles
		this.panelActionsPossibles = new JPanel();
		this.panelActionsPossibles.setBounds(this.getWidth()*1/5, 0, this.getWidth() * 3 / 5, this.getHeight());
		this.panelInterne = new JPanel();
		this.initCl(this.enumCl[this.enumCl.length-1]);
		this.panelActionsPossibles.add(this.panelInterne);
		this.add(this.panelActionsPossibles);
		
	}

	// **********MUTATEURS

	// **********METHODES
	public void creerMap() {
		int i, j;
		this.panelMap = new JPanel();
		this.panelMap.setBounds(0, 0, this.getWidth() / 5, this.getHeight());

		this.mapLargeur = this.saFenetre.affichagejeu.getNbrCaseLarge();
		this.mapHauteur = this.saFenetre.affichagejeu.getNbrCaseHauteur();

		if (this.mapLargeur >= this.mapHauteur) {
			this.map = new JButton[this.mapLargeur][this.mapLargeur];
			this.panelMap.setLayout(new GridLayout(this.mapLargeur, this.mapLargeur));
			for (i = 0; i < this.mapLargeur; i++) {
				for (j = 0; j < this.mapLargeur; j++) {
					this.map[i][j] = new JButton();
					this.panelMap.add(this.map[i][j]);
					this.map[i][j].setBorder(null);
				}
			}
		} else {
			this.map = new JButton[this.mapHauteur][this.mapHauteur];
			this.panelMap.setLayout(new GridLayout(this.mapHauteur, this.mapHauteur));
			for (i = 0; i < this.mapHauteur; i++) {
				for (j = 0; j < this.mapHauteur; j++) {
					this.map[i][j] = new JButton();
					this.panelMap.add(this.map[i][j]);
					this.map[i][j].setBorder(null);
				}
			}
		}
		updateMap();
	}

	public void initCl(String aAfficher) {
		this.cl = new CardLayout();
		this.panelInterne.setLayout(cl);
		this.jcard = new JPanel[this.enumCl.length];
		for (int i = 0; i < this.jcard.length; i++) {
			this.jcard[i] = new JPanel();
			this.jcard[i].setLayout(new FlowLayout());
			this.panelInterne.add(this.jcard[i], this.enumCl[i]);
		}
		
		String[] boutonpossible = {"archer","cavalier archer", "d�truire", 
				"catapultes", "d�truire", 
				"milicien", "d�truire", 
				"chevalier", "d�truire",
				"peon", "d�truire",
				"d�truire",
				"gal�re","tranporteur", "d�truire",
				"d�truire",
				"magicien", "healers", "d�truire",
				"d�truire"};
		this.actionPossible = new JButton[boutonpossible.length];  //valeur � changer pour rajouter des actions possibles
		int j=0;
		for (int i= 0; i< boutonpossible.length; i++){
			this.actionPossible[i] = new JButton(boutonpossible[i]);
			this.jcard[j].add(this.actionPossible[i]);
			if (boutonpossible[i] == "d�truire"){
				//System.out.println("je passe ici");
				j++;
				if (j>=this.jcard.length){
					System.out.println("probl�me lors de l'initialisation du card layout du panel bas");
				}
			}
		}
		
		this.cl.show(this.panelInterne,aAfficher);
	}

	protected void updateMap() {
		int i, j, test, test2;

		this.mapLargeur = this.saFenetre.affichagejeu.getNbrCaseLarge();
		this.mapHauteur = this.saFenetre.affichagejeu.getNbrCaseHauteur();

		if (this.mapLargeur >= this.mapHauteur) {
			test = (int) Math.floor((this.mapLargeur - this.mapHauteur) / 2);
			test2 = this.mapLargeur - this.mapHauteur - test;
			for (i = 0; i < this.mapLargeur; i++) {
				for (j = 0; j < this.mapLargeur; j++) {
					if (i < test2 || i >= (this.mapHauteur + test2)) {
						this.map[i][j].setBackground(Color.black);
					} else {
						this.map[i][j].setBackground(this.saFenetre.affichagejeu.getCarte(i - test2, j).getBackground());
					}
				}
			}
		} else {
			test = (int) Math.floor((this.mapHauteur - this.mapLargeur) / 2);
			test2 = this.mapHauteur - this.mapLargeur - test;
			for (i = 0; i < this.mapHauteur; i++) {
				for (j = 0; j < this.mapHauteur; j++) {
					if (j < test2 || j >= (this.mapLargeur + test2)) {
						this.map[i][j].setBackground(Color.black);
					} else {
						this.map[i][j].setBackground(this.saFenetre.affichagejeu.getCarte(i, j - test2).getBackground());
					}
				}
			}
		}
	}

	public void updatePanelInfo(Case bouh) {
		this.infoText.setText("case " + bouh.getTexture().toString());
		if (bouh.isBatimentsurcase()) {
			this.infoText.append("\nil y a un batiment � Batman sur la case");
		} else if (bouh.isUnitesurcase()) {
			this.infoText.append("\nil y a une unit� sur la case");
		}
	}

	public void updateActionPossible(Case bouh, int hauteur, int largeur) {
		this.panelInterne.removeAll();
		if (bouh.isBatimentsurcase()) {
			Batiment batimentSurLaCase = (Batiment) recuperer(hauteur, largeur, true);
			System.out.println(batimentSurLaCase.getNOM());
			initCl(batimentSurLaCase.getNOM());			
		}

	}
//"Archerie", "atelier de si�ge", "Caserne", "Ecurie", "Hotel de ville", "Mur", "Port", "mine", "Tour des mages", "Tourelle","casevide"
	private Object recuperer(int hauteur, int largeur, boolean wantBatiment) {
		if (wantBatiment) {
			for (Joueur ceJoueur : this.saFenetre.lesJoueurs) {
				ArrayList<Batiment> batimentPossible = ceJoueur.getBatiments();
				for (Batiment celuiLa : batimentPossible) {
					if (celuiLa.getPOSITION(0) == largeur && celuiLa.getPOSITION(1) == hauteur) {
						this.infoText.append("il y a sur cette case : " + celuiLa.getNOM());
						return celuiLa;
					}
				}
			}
		} else {
			for (Joueur ceJoueur : this.saFenetre.lesJoueurs) {
				ArrayList<Personnage> personnagePossible = ceJoueur.getPersonnages();
				for (Personnage celuiLa : personnagePossible) {
					if (celuiLa.getPositionHorizontale() == largeur && celuiLa.getPositionVerticale() == hauteur) {
						this.infoText.append("il y a sur cette case : " + celuiLa.getNOM());
						return celuiLa;
					}
				}
			}
		}
		return null;
	}

	
}
