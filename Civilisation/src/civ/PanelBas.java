package civ;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

import Unites.Personnage;
import joueur.Joueur;
import Batiment.Batiment;

public class PanelBas extends JPanel implements ActionListener {
	/*
	 * Panel qui servira à afficher la panelMap, les stats du trucs
	 * selectionnés, les actions réalisbles
	 */

	// **********VARIABLES
	private JPanel panelMap, panelActionsPossibles;
	private FntPrcpl saFenetre;
	private JButton[][] map;
	private int mapLargeur, mapHauteur;
	JTextArea infoText;
	CardLayout cl;
	String[] enumCl = { "SuperMouton", "Archerie", "atelier de siège", "Caserne", "Ecurie", "Hotel de ville", "Mur", "Port", "mine",
			"Tour des mages", "Tourelle", "Archer", "Catapulte", "Cavalier archer", "Chevalier", "Galere", "Healer", "Magicien", "Milicien", "Peon",
			"Transporteur", "casevide" };
	JPanel[] jcard;
	JButton[] actionPossible;
	public boolean actionEnCours = false;
	String quelleActionEnCours;
	Object trucActuellementSelectionne = null;
	boolean utilisable = false;
	int[] positionDeLaCaseActuellementSelectionnee = new int[2];
	int unBatimentOuUneUnité = -1, ancienBatiment = -1; // unité 1 batiment 0

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
		this.panelActionsPossibles.setBounds(this.getWidth() * 1 / 5, 0, this.getWidth() * 3 / 5, this.getHeight());
		this.initCl(this.enumCl[this.enumCl.length - 1], false);
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

	public void initCl(String aAfficher, boolean peutmodifier) {
		this.cl = new CardLayout();
		this.panelActionsPossibles.setLayout(cl);
		this.jcard = new JPanel[this.enumCl.length];
		for (int i = 0; i < this.jcard.length; i++) {
			this.jcard[i] = new JPanel();
			this.jcard[i].setLayout(new FlowLayout());
			this.panelActionsPossibles.add(this.jcard[i], this.enumCl[i]);
		}
		if (peutmodifier) {
			String[] boutonpossible = { "déplacer", "détruire", "archer", "cavalier archer", "détruire", "catapultes", "détruire", "milicien",
					"détruire", "chevalier", "détruire", "peon", "SuperMouton", "détruire", "détruire", "galère", "tranporteur", "détruire", "détruire", "magicien",
					"healers", "détruire", "attaquer", "détruire", "déplacer", "attaquer", "détruire", "déplacer", "attaquer", "détruire",
					"déplacer", "attaquer", "détruire", "déplacer", "attaquer", "détruire", "déplacer", "attaquer", "détruire", "déplacer",
					"soigner", "détruire", "déplacer", "attaquer", "détruire", "déplacer", "attaquer", "détruire", "Archerie", "atelier de siège",
					"Caserne", "Ecurie", "Hotel de ville", "Mur", "Port", "mine or", "mine nourriture", "mine bois", "mine fer", "mine pierre",
					"Tour des mages", "Tourelle", "déplacer", "rechercher", "détruire", "déplacer", "attaquer", "détruire" };
			this.actionPossible = new JButton[boutonpossible.length];
			int j = 0;

			for (int i = 0; i < boutonpossible.length; i++) {
				this.actionPossible[i] = new JButton(boutonpossible[i]);
				this.jcard[j].add(this.actionPossible[i]);

				if (!this.utilisable) {
					this.actionPossible[i].setEnabled(false);
				} else {
					this.actionPossible[i].addActionListener(this);
				}
				if (boutonpossible[i] == "détruire") {
					j++;
					if (j >= this.jcard.length) {
						System.out.println("problème lors de l'initialisation du card layout du panel bas");
					}
				}
			}
			if (actionEnCours) {
				JLabel quoifaire = new JLabel("selectionner une case où executer l'action en cours");
				this.jcard[j].add(quoifaire);
			}
		}

		this.cl.show(this.panelActionsPossibles, aAfficher);
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
						if (this.map[i][j].getBorder() != null) {
							this.map[i][j].setBorder(null);
						}
						if (this.saFenetre.affichagejeu.getCarte(i - test2, j).getBorder() != BorderFactory.createEtchedBorder(EtchedBorder.LOWERED)) {
							this.map[i][j].setBorder(this.saFenetre.affichagejeu.getCarte(i - test2, j).getBorder());
						}
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

	public void updateActionPossible(Case bouh, int hauteur, int largeur) {
		this.positionDeLaCaseActuellementSelectionnee[0] = largeur;
		this.positionDeLaCaseActuellementSelectionnee[1] = hauteur;

		this.panelActionsPossibles.removeAll();
		this.infoText.setText("case " + bouh.getTexture().toString());
		if (!actionEnCours) {

			Batiment batimentSurLaCase = (Batiment) recuperer(hauteur, largeur, true);
			trucActuellementSelectionne = batimentSurLaCase;
			if (batimentSurLaCase != null) {
				this.unBatimentOuUneUnité = 0;
				if (batimentSurLaCase.getIsUsed()) {
					this.utilisable = false;
				} else {
					this.utilisable = true;
				}
				this.infoText.append("\n" + batimentSurLaCase.getNOM() + "\n" + batimentSurLaCase.getPV() + " PV\nBatiment utlisé? "
						+ batimentSurLaCase.getIsUsed());
				if (trouverJoueur(hauteur, largeur, true)) {
					initCl(batimentSurLaCase.getNOM(), true);
				} else {
					System.out.println(batimentSurLaCase.getNOM());
					initCl(batimentSurLaCase.getNOM(), false);
				}
			} else {
				Personnage personneSurLaCase = (Personnage) recuperer(hauteur, largeur, false);
				if (personneSurLaCase != null) {
					trucActuellementSelectionne = personneSurLaCase;
					this.infoText.append("\n" + personneSurLaCase.getNOM() + "\n" + personneSurLaCase.getPV() + " PV/" + personneSurLaCase.PVMax
							+ "\nUnité utilisée? " + personneSurLaCase.isUsed());
					this.unBatimentOuUneUnité = 1;
					if (personneSurLaCase.isUsed()) {
						this.utilisable = false;
					} else {
						this.utilisable = true;
					}
					if (trouverJoueur(hauteur, largeur, false)) {
						initCl(personneSurLaCase.getNOM(), true);
					} else {
						initCl(personneSurLaCase.getNOM(), false);
					}
				} else {
					initCl("casevide", true);
					trucActuellementSelectionne = null;
				}
			}
		} else {
			initCl("casevide", true);
		}
	}

	private Object recuperer(int hauteur, int largeur, boolean wantBatiment) {
		if (wantBatiment) {
			for (Joueur ceJoueur : this.saFenetre.lesJoueurs) {
				ArrayList<Batiment> batimentPossible = ceJoueur.getBatiments();
				for (Batiment celuiLa : batimentPossible) {
					if (celuiLa.getPOSITION(0) == largeur && celuiLa.getPOSITION(1) == hauteur) {
						return celuiLa;
					}
				}
			}
		} else {
			for (Joueur ceJoueur : this.saFenetre.lesJoueurs) {
				ArrayList<Personnage> personnagePossible = ceJoueur.getPersonnages();
				for (Personnage celuiLa : personnagePossible) {
					if (celuiLa.getPositionHorizontale() == largeur && celuiLa.getPositionVerticale() == hauteur) {
						return celuiLa;
					}
				}
			}
		}
		return null;
	}

	private boolean trouverJoueur(int hauteur, int largeur, boolean wantBatiment) {
		if (wantBatiment) {
			int i = 0;
			for (Joueur ceJoueur : this.saFenetre.lesJoueurs) {
				ArrayList<Batiment> batimentPossible = ceJoueur.getBatiments();
				for (Batiment celuiLa : batimentPossible) {
					if (celuiLa.getPOSITION(0) == largeur && celuiLa.getPOSITION(1) == hauteur) {
						if (i == PanelResrc.joueurencours) {
							return true;
						} else {
							return false;
						}
					}
				}
				i++;
			}
		} else {
			int i = 0;
			for (Joueur ceJoueur : this.saFenetre.lesJoueurs) {
				ArrayList<Personnage> personnagePossible = ceJoueur.getPersonnages();
				for (Personnage celuiLa : personnagePossible) {
					if (celuiLa.getPositionHorizontale() == largeur && celuiLa.getPositionVerticale() == hauteur) {
						if (i == PanelResrc.joueurencours) {
							return true;
						} else {
							return false;
						}
					}
				}
				i++;
			}
		}
		return false;
	}

	private void detruireUnObjet() {
		JOptionPane jpop = new JOptionPane();
		int option = jpop.showConfirmDialog(null, "Voulez vous vraiment détruire ce qu'il y a sur cette case?", "confirmation",
				JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if (option == JOptionPane.OK_OPTION) {
			if (unBatimentOuUneUnité == 0) {
				Batiment bouh1 = (Batiment) this.trucActuellementSelectionne;
				bouh1.destructionBatiment(this.saFenetre.affichagejeu.getCarte(this.positionDeLaCaseActuellementSelectionnee[0],
						this.positionDeLaCaseActuellementSelectionnee[1]), this.saFenetre.lesJoueurs[PanelResrc.joueurencours]);
				if (!this.saFenetre.affichagejeu.getCarte(this.positionDeLaCaseActuellementSelectionnee[0],
						this.positionDeLaCaseActuellementSelectionnee[1]).isBatimentsurcase()) {
				}
			} else {
				Personnage bouh = (Personnage) this.trucActuellementSelectionne;
				bouh.destructionUnite(this.saFenetre.lesJoueurs[PanelResrc.joueurencours]);
			}
		}
	}

	public void executerActionComplexe(int positionHauteur, int positionLargeur) {
		this.positionDeLaCaseActuellementSelectionnee[0] = positionHauteur;
		this.positionDeLaCaseActuellementSelectionnee[1] = positionLargeur;
		// System.out.println(this.positionDeLaCaseActuellementSelectionnee[0] +
		// "/" + this.positionDeLaCaseActuellementSelectionnee[1]);
		switch (quelleActionEnCours) {
			case "attaquer":
				if (this.ancienBatiment == 1) {
					if (!Evenements.Boutons.attaque((Personnage) this.trucActuellementSelectionne, this.positionDeLaCaseActuellementSelectionnee[1],
							this.positionDeLaCaseActuellementSelectionnee[0], this.saFenetre.affichagejeu.getCarte(
									this.positionDeLaCaseActuellementSelectionnee[0], this.positionDeLaCaseActuellementSelectionnee[1]),
									this.saFenetre.lesJoueurs)) {
						JOptionPane.showMessageDialog(null, "Trop loin ou personne !", "Problème", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					if (!Evenements.Boutons.attaqueTourelle((Batiment) this.trucActuellementSelectionne,
							this.positionDeLaCaseActuellementSelectionnee[1], this.positionDeLaCaseActuellementSelectionnee[0],
							this.saFenetre.affichagejeu.getCarte(this.positionDeLaCaseActuellementSelectionnee[0],
									this.positionDeLaCaseActuellementSelectionnee[1]), this.saFenetre.lesJoueurs)) {
						JOptionPane.showMessageDialog(null, "Trop loin ou personne !", "Problème", JOptionPane.ERROR_MESSAGE);
					}
				}
				break;
			case "déplacer":
				if (!Evenements.Boutons.deplace((Personnage) this.trucActuellementSelectionne, this.positionDeLaCaseActuellementSelectionnee[1],
						this.positionDeLaCaseActuellementSelectionnee[0], this.saFenetre.affichagejeu.getCarte(
								this.positionDeLaCaseActuellementSelectionnee[0], this.positionDeLaCaseActuellementSelectionnee[1]),
								this.saFenetre.lesJoueurs)) {
					JOptionPane.showMessageDialog(null, "Trop loin ou occupé !", "Problème", JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "soigner":
				if (!Evenements.Boutons.soigne((Personnage) this.trucActuellementSelectionne, this.positionDeLaCaseActuellementSelectionnee[1],
						this.positionDeLaCaseActuellementSelectionnee[0], this.saFenetre.affichagejeu.getCarte(
								this.positionDeLaCaseActuellementSelectionnee[0], this.positionDeLaCaseActuellementSelectionnee[1]),
								this.saFenetre.lesJoueurs)) {
					JOptionPane.showMessageDialog(null, "Trop loin ou vide !", "Problème", JOptionPane.ERROR_MESSAGE);
				}
				break;
			default:
				System.out.println("problème lors de la recuperation de l'action complexe à effectuer");
		}
		this.actionEnCours = false;
		this.saFenetre.updateAffichage();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.ancienBatiment = this.unBatimentOuUneUnité;
		JButton boutonAppuye = (JButton) e.getSource();
		switch (boutonAppuye.getText()) {
			case "détruire":
				this.detruireUnObjet();
				break;
			case "déplacer":
				this.actionEnCours = true;
				this.quelleActionEnCours = "déplacer";
				updateActionPossible(this.saFenetre.affichagejeu.getCarte(this.positionDeLaCaseActuellementSelectionnee[0],
						this.positionDeLaCaseActuellementSelectionnee[1]), this.positionDeLaCaseActuellementSelectionnee[0],
						this.positionDeLaCaseActuellementSelectionnee[1]);
				break;
			case "attaquer":
				this.actionEnCours = true;
				this.quelleActionEnCours = "attaquer";
				updateActionPossible(this.saFenetre.affichagejeu.getCarte(this.positionDeLaCaseActuellementSelectionnee[0],
						this.positionDeLaCaseActuellementSelectionnee[1]), this.positionDeLaCaseActuellementSelectionnee[0],
						this.positionDeLaCaseActuellementSelectionnee[1]);
				break;
			case "archer":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].isArcherCreated(this.positionDeLaCaseActuellementSelectionnee)) {
					JOptionPane.showMessageDialog(null, "Pas assez de ressource ou de place autour du batiment pour executer cette action",
							"Problème", JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "cavalier archer":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].isCavalierArcherCreated(this.positionDeLaCaseActuellementSelectionnee)) {
					JOptionPane.showMessageDialog(null, "Pas assez de ressource ou de place autour du batiment pour executer cette action",
							"Problème", JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "SuperMouton":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].IsSuperMoutonCreated(this.positionDeLaCaseActuellementSelectionnee)) {
					JOptionPane.showMessageDialog(null, "Pas assez de ressource ou de place autour du batiment pour executer cette action",
							"Problème", JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "catapultes":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].isCatapulteCreated(this.positionDeLaCaseActuellementSelectionnee)) {
					JOptionPane.showMessageDialog(null, "Pas assez de ressource ou de place autour du batiment pour executer cette action",
							"Problème", JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "milicien":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].isMilicienCreated(this.positionDeLaCaseActuellementSelectionnee)) {
					JOptionPane.showMessageDialog(null, "Pas assez de ressource ou de place autour du batiment pour executer cette action",
							"Problème", JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "chevalier":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].isChevalierCreated(this.positionDeLaCaseActuellementSelectionnee)) {
					JOptionPane.showMessageDialog(null, "Pas assez de ressource ou de place autour du batiment pour executer cette action",
							"Problème", JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "peon":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].isPeonCreated(this.positionDeLaCaseActuellementSelectionnee)) {
					JOptionPane.showMessageDialog(null, "Pas assez de ressource ou de place autour du batiment pour executer cette action",
							"Problème", JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "galère":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].isGalereCreated(this.positionDeLaCaseActuellementSelectionnee)) {
					JOptionPane.showMessageDialog(null, "Pas assez de ressource ou de place autour du batiment pour executer cette action",
							"Problème", JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "tranporteur":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].isTransporteurCreated(this.positionDeLaCaseActuellementSelectionnee)) {
					JOptionPane.showMessageDialog(null, "Pas assez de ressource ou de place autour du batiment pour executer cette action",
							"Problème", JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "magicien":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].isMagicirnrCreated(this.positionDeLaCaseActuellementSelectionnee)) {
					JOptionPane.showMessageDialog(null, "Pas assez de ressource ou de place autour du batiment pour executer cette action",
							"Problème", JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "healers":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].isHealerCreated(this.positionDeLaCaseActuellementSelectionnee)) {
					JOptionPane.showMessageDialog(null, "Pas assez de ressource ou de place autour du batiment pour executer cette action",
							"Problème", JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "soigner":
				this.actionEnCours = true;
				this.quelleActionEnCours = "soigner";
				updateActionPossible(this.saFenetre.affichagejeu.getCarte(this.positionDeLaCaseActuellementSelectionnee[0],
						this.positionDeLaCaseActuellementSelectionnee[1]), this.positionDeLaCaseActuellementSelectionnee[0],
						this.positionDeLaCaseActuellementSelectionnee[1]);
				break;
			case "Archerie":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].isArcherieConstructed(this.positionDeLaCaseActuellementSelectionnee,
						this.saFenetre.affichagejeu.getCarte(this.positionDeLaCaseActuellementSelectionnee[1],
								this.positionDeLaCaseActuellementSelectionnee[0]))) {
					JOptionPane.showMessageDialog(null, "Pas assez de ressource ou de place autour du batiment pour executer cette action",
							"Problème", JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "atelier de siège":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].isAtelierDeSiegeConstructed(this.positionDeLaCaseActuellementSelectionnee,
						this.saFenetre.affichagejeu.getCarte(this.positionDeLaCaseActuellementSelectionnee[1],
								this.positionDeLaCaseActuellementSelectionnee[0]))) {
					JOptionPane.showMessageDialog(null, "Pas assez de ressource ou de place autour du batiment pour executer cette action",
							"Problème", JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "Caserne":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].isCaserneConstructed(this.positionDeLaCaseActuellementSelectionnee,
						this.saFenetre.affichagejeu.getCarte(this.positionDeLaCaseActuellementSelectionnee[1],
								this.positionDeLaCaseActuellementSelectionnee[0]))) {
					JOptionPane.showMessageDialog(null, "Pas assez de ressource ou de place autour du batiment pour executer cette action",
							"Problème", JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "Ecurie":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].isEcurieConstructed(this.positionDeLaCaseActuellementSelectionnee,
						this.saFenetre.affichagejeu.getCarte(this.positionDeLaCaseActuellementSelectionnee[1],
								this.positionDeLaCaseActuellementSelectionnee[0]))) {
					JOptionPane.showMessageDialog(null, "Pas assez de ressource ou de place autour du batiment pour executer cette action",
							"Problème", JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "Hotel de ville":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].isHotelDeVilleConstructed(this.positionDeLaCaseActuellementSelectionnee,
						this.saFenetre.affichagejeu.getCarte(this.positionDeLaCaseActuellementSelectionnee[1],
								this.positionDeLaCaseActuellementSelectionnee[0]))) {
					JOptionPane.showMessageDialog(null, "Pas assez de ressource ou de place autour du batiment pour executer cette action",
							"Problème", JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "Mur":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].isMurConstructed(this.positionDeLaCaseActuellementSelectionnee,
						this.saFenetre.affichagejeu.getCarte(this.positionDeLaCaseActuellementSelectionnee[1],
								this.positionDeLaCaseActuellementSelectionnee[0]))) {
					JOptionPane.showMessageDialog(null, "Pas assez de ressource ou de place autour du batiment pour executer cette action",
							"Problème", JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "Port":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].isPortConstructed(this.positionDeLaCaseActuellementSelectionnee,
						this.saFenetre.affichagejeu.getCarte(this.positionDeLaCaseActuellementSelectionnee[1],
								this.positionDeLaCaseActuellementSelectionnee[0]))) {
					JOptionPane.showMessageDialog(null, "Pas assez de ressource ou de place autour du batiment pour executer cette action",
							"Problème", JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "mine or":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].isMineOrConstructed(this.positionDeLaCaseActuellementSelectionnee,
						this.saFenetre.affichagejeu.getCarte(this.positionDeLaCaseActuellementSelectionnee[1],
								this.positionDeLaCaseActuellementSelectionnee[0]))) {
					JOptionPane.showMessageDialog(null, "Pas assez de ressource ou de place autour du batiment pour executer cette action",
							"Problème", JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "mine nourriture":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].isMineNourritureConstructed(this.positionDeLaCaseActuellementSelectionnee,
						this.saFenetre.affichagejeu.getCarte(this.positionDeLaCaseActuellementSelectionnee[1],
								this.positionDeLaCaseActuellementSelectionnee[0]))) {
					JOptionPane.showMessageDialog(null, "Pas assez de ressource ou de place autour du batiment pour executer cette action",
							"Problème", JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "mine bois":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].isMineBoisConstructed(this.positionDeLaCaseActuellementSelectionnee,
						this.saFenetre.affichagejeu.getCarte(this.positionDeLaCaseActuellementSelectionnee[1],
								this.positionDeLaCaseActuellementSelectionnee[0]))) {
					JOptionPane.showMessageDialog(null, "Pas assez de ressource ou de place autour du batiment pour executer cette action",
							"Problème", JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "mine fer":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].isMineFerConstructed(this.positionDeLaCaseActuellementSelectionnee,
						this.saFenetre.affichagejeu.getCarte(this.positionDeLaCaseActuellementSelectionnee[1],
								this.positionDeLaCaseActuellementSelectionnee[0]))) {
					JOptionPane.showMessageDialog(null, "Pas assez de ressource ou de place autour du batiment pour executer cette action",
							"Problème", JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "mine pierre":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].isMinePierreConstructed(this.positionDeLaCaseActuellementSelectionnee,
						this.saFenetre.affichagejeu.getCarte(this.positionDeLaCaseActuellementSelectionnee[1],
								this.positionDeLaCaseActuellementSelectionnee[0]))) {
					JOptionPane.showMessageDialog(null, "Pas assez de ressource ou de place autour du batiment pour executer cette action",
							"Problème", JOptionPane.ERROR_MESSAGE);
				}
				break;

			case "rechercher":
				Evenements.Boutons.cherche((Personnage) this.trucActuellementSelectionne);
				break;

			case "Tour des mages":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].isTourDesMagesConstructed(this.positionDeLaCaseActuellementSelectionnee,
						this.saFenetre.affichagejeu.getCarte(this.positionDeLaCaseActuellementSelectionnee[1],
								this.positionDeLaCaseActuellementSelectionnee[0]))) {
					JOptionPane.showMessageDialog(null, "Pas assez de ressource ou de place autour du batiment pour executer cette action",
							"Problème", JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "Tourelle":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].isTourelleConstructed(this.positionDeLaCaseActuellementSelectionnee,
						this.saFenetre.affichagejeu.getCarte(this.positionDeLaCaseActuellementSelectionnee[1],
								this.positionDeLaCaseActuellementSelectionnee[0]))) {
					JOptionPane.showMessageDialog(null, "Pas assez de ressource ou de place autour du batiment pour executer cette action",
							"Problème", JOptionPane.ERROR_MESSAGE);
				}
				break;
			default:
				System.out.println("problème lors de la recuperation de l'action à affectuer");
		}
		this.saFenetre.updateAffichage();
	}
}
