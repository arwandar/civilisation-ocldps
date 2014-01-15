package civ;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import joueur.Joueur;
import Batiment.Batiment;

public class PanelBas extends JPanel {
	/*
	 * Panel qui servira à afficher la panelMap, les stats du trucs
	 * selectionnés, les actions réalisbles
	 */

	// **********VARIABLES
	private JPanel panelMap, panelActionsPossibles, panelInterne;
	private FntPrcpl saFenetre;
	private JButton[][] map;
	private int mapLargeur, mapHauteur;
	JTextArea infoText;

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
		this.panelActionsPossibles.setBounds(0, this.getWidth() / 5, this.getWidth() * 3 / 5, this.getHeight());
		this.panelInterne = new JPanel();
		this.panelActionsPossibles.add(this.panelInterne);
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
			this.infoText.append("\nil y a un batiment à Batman sur la case");
		} else if (bouh.isUnitesurcase()) {
			this.infoText.append("\nil y a une unité sur la case");
			
		}
	}

	public void updateActionPossible(Case bouh, int hauteur, int largeur){
		this.panelInterne.removeAll();
		boolean test=false;
		if (bouh.isBatimentsurcase()){
			Batiment batimentSurLaCase= null;
			for (Joueur ceJoueur : this.saFenetre.lesJoueurs){
				ArrayList<Batiment> batimentPossible = ceJoueur.getBatiments();
				for (Batiment celuiLa : batimentPossible){
					if (celuiLa.getPOSITION(0)==largeur && celuiLa.getPOSITION(1)==hauteur){
						batimentSurLaCase = celuiLa;
						test = true;
						break;
					}
				}
				if (test){
					break;
				}
				this.infoText.setText("il y a sur cette case : "+batimentSurLaCase.getNOM());
				
			}
			
		}
		else if(bouh.isUnitesurcase()){

		}

	}
	
	private String recupererNom(Case bouh, int hauteur, int largeur){
		return null;
		
	}
}
