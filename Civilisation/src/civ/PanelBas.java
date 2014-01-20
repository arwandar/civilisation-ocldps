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

import joueur.Joueur;
import Batiment.Batiment;
import Unites.Personnage;

public class PanelBas extends JPanel implements ActionListener {
	/*
	 * Panel qui servira � afficher la panelMap, les stats du trucs
	 * selectionn�s, les actions r�alisbles
	 */

	// **********VARIABLES
	private JPanel panelMap, panelActionsPossibles;
	private FntPrcpl saFenetre;
	private JButton[][] map;
	private int mapLargeur, mapHauteur;
	JTextArea infoText;
	CardLayout cl;
	String[] enumCl = { "SuperMouton", "Archerie", "atelier de si�ge", "Caserne", "Ecurie", "Hotel de ville", "Mur", "Port", "mine",
			"Tour des mages", "Tourelle", "Archer", "Catapulte", "Cavalier archer", "Chevalier", "Galere", "Healer", "Magicien", "Milicien", "Peon",
			"Transporteur", "casevide" };
	JPanel[] jcard;
	JButton[] actionPossible;
	public boolean actionEnCours = false;
	String quelleActionEnCours;
	Object trucActuellementSelectionne = null;
	boolean utilisable = false;
	int[] positionDeLaCaseActuellementSelectionnee = new int[2];
	int unBatimentOuUneUnit� = -1, ancienBatiment = -1; // unit� 1 batiment 0

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
			String[] boutonpossible = { "d�placer", "d�truire", "archer", "cavalier archer", "d�truire", "catapultes", "d�truire", "milicien",
					"d�truire", "chevalier", "d�truire", "peon", "SuperMouton", "d�truire", "d�truire", "gal�re", "tranporteur", "d�truire",
					"d�truire", "magicien", "healers", "d�truire", "attaquer", "d�truire", "d�placer", "attaquer", "d�truire", "d�placer",
					"attaquer", "d�truire", "d�placer", "attaquer", "d�truire", "d�placer", "attaquer", "d�truire", "d�placer", "attaquer",
					"d�truire", "d�placer", "soigner", "d�truire", "d�placer", "attaquer", "d�truire", "d�placer", "attaquer", "d�truire",
					"Archerie", "atelier de si�ge", "Caserne", "Ecurie", "Hotel de ville", "Mur", "Port", "mine or", "mine nourriture", "mine bois",
					"mine fer", "mine pierre", "Tour des mages", "Tourelle", "d�placer", "rechercher", "d�truire", "d�placer", "attaquer", "d�truire" };
			this.actionPossible = new JButton[boutonpossible.length];
			int j = 0;
			Joueur leJoueur = this.saFenetre.lesJoueurs[PanelResrc.joueurencours];

			for (int i = 0; i < boutonpossible.length; i++) {
				this.actionPossible[i] = new JButton(boutonpossible[i]);
				this.jcard[j].add(this.actionPossible[i]);

				if (!this.utilisable) {
					this.actionPossible[i].setEnabled(false);
				} else {
					this.actionPossible[i].addActionListener(this);
				}
				if (boutonpossible[i] == "d�truire") {
					j++;
					if (j >= this.jcard.length) {
						System.out.println("probl�me lors de l'initialisation du card layout du panel bas");
					}
				}

				switch (boutonpossible[i]) {
					case "archer":
						infobulle(this.actionPossible[i], leJoueur, 45, 25, 0, 0, 0);
						break;
					case "cavalier archer":
						infobulle(this.actionPossible[i], leJoueur, 70, 40, 0, 0, 0);
						break;
					case "catapultes":
						infobulle(this.actionPossible[i], leJoueur, 0, 0, 0, 0, 0);
						break;
					case "milicien":
						infobulle(this.actionPossible[i], leJoueur, 20, 0, 60, 0, 0);
						break;
					case "chevalier":
						infobulle(this.actionPossible[i], leJoueur, 50, 0, 60, 0, 0);
						break;
					case "peon":
						infobulle(this.actionPossible[i], leJoueur, 0, 0, 10, 0, 0);
						break;
					case "SuperMouton":
						infobulle(this.actionPossible[i], leJoueur, 0, 0, 10, 0, 0);
						break;
					case "gal�re":
						infobulle(this.actionPossible[i], leJoueur, 30, 90, 0, 0, 0);
						break;
					case "tranporteur":
						infobulle(this.actionPossible[i], leJoueur, 0, 125, 0, 0, 0);
						break;
					case "magicien":
						infobulle(this.actionPossible[i], leJoueur, 40, 0, 50, 0, 0);
						break;
					case "healers":
						infobulle(this.actionPossible[i], leJoueur, 50, 0, 40, 0, 0);
						break;

					case "Archerie":
						infobulle(this.actionPossible[i], leJoueur, 50, 100, 0, 50, 150);
						break;
					case "atelier de si�ge":
						infobulle(this.actionPossible[i], leJoueur, 200, 300, 0, 150, 450);
						break;
					case "Caserne":
						infobulle(this.actionPossible[i], leJoueur, 50, 75, 0, 35, 110);
						break;
					case "Ecurie":
						infobulle(this.actionPossible[i], leJoueur, 150, 200, 0, 100, 300);
						break;
					case "Hotel de ville":
						infobulle(this.actionPossible[i], leJoueur, 200, 300, 0, 150, 200);
						break;
					case "Mur":
						infobulle(this.actionPossible[i], leJoueur, 10, 30, 0, 5, 50);
						break;
					case "Port":
						infobulle(this.actionPossible[i], leJoueur, 75, 300, 0, 50, 100);
						break;
					case "mine or":
						infobulle(this.actionPossible[i], leJoueur, 20, 10, 0, 5, 30);
						break;
					case "mine nourriture":
						infobulle(this.actionPossible[i], leJoueur, 20, 10, 0, 5, 30);
						break;
					case "mine bois":
						infobulle(this.actionPossible[i], leJoueur, 20, 10, 0, 5, 30);
						break;
					case "mine fer":
						infobulle(this.actionPossible[i], leJoueur, 20, 10, 0, 5, 30);
						break;
					case "mine pierre":
						infobulle(this.actionPossible[i], leJoueur, 20, 10, 0, 5, 30);
						break;
					case "Tour des mages":
						infobulle(this.actionPossible[i], leJoueur, 75, 150, 0, 50, 150);
						break;
					case "Tourelle":
						infobulle(this.actionPossible[i], leJoueur, 100, 300, 0, 50, 500);
						break;
				}
			}
			if (actionEnCours) {
				JLabel quoifaire = new JLabel("selectionner une case o� executer l'action en cours");
				this.jcard[j].add(quoifaire);
			}
		}

		this.cl.show(this.panelActionsPossibles, aAfficher);
	}

	private void infobulle(JButton bouh, Joueur leJoueur, int coutOr, int coutBois, int coutNourriture, int coutFer, int coutPierre) {
		if (leJoueur.getBois() <= coutBois || leJoueur.getOr() <= coutOr || leJoueur.getNourriture() <= coutNourriture
				|| leJoueur.getFer() <= coutFer || leJoueur.getPierre() <= coutPierre) {
			bouh.setEnabled(false);
		}
		bouh.setToolTipText("or : " + coutOr + " / fer : " + coutFer + " / nourriture : " + coutNourriture + " / bois : " + coutBois + " / pierre : "
				+ coutPierre);
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
				this.unBatimentOuUneUnit� = 0;
				if (batimentSurLaCase.getIsUsed()) {
					this.utilisable = false;
				} else {
					this.utilisable = true;
				}
				this.infoText.append("\n" + batimentSurLaCase.getNOM() + "\n" + batimentSurLaCase.getPV() + " PV\nBatiment utlis�? "
						+ batimentSurLaCase.getIsUsed() + "\nAttaque : " + batimentSurLaCase.getATT() + "\nD�fense : " + batimentSurLaCase.getDEF()+"\nPort�e : "+batimentSurLaCase.getPortee());
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
					this.infoText.append("\n" + personneSurLaCase.getNOM() + "\n" + personneSurLaCase.getPV() + "/" + personneSurLaCase.PVMax
							+ "PV\nUnit� utilis�e? " + personneSurLaCase.isUsed() + "\nD�placement : " + personneSurLaCase.getMouvement()
							+ "\nAttaque : " + personneSurLaCase.getAttaque() + "\nD�fense : " + personneSurLaCase.getDefense()+"\nPort�e : "+personneSurLaCase.getPortee());
					this.unBatimentOuUneUnit� = 1;
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
		int option = jpop.showConfirmDialog(null, "Voulez vous vraiment d�truire ce qu'il y a sur cette case?", "confirmation",
				JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if (option == JOptionPane.OK_OPTION) {
			if (unBatimentOuUneUnit� == 0) {
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
						JOptionPane.showMessageDialog(null, "Trop loin ou personne !", "Probl�me", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					if (!Evenements.Boutons.attaqueTourelle((Batiment) this.trucActuellementSelectionne,
							this.positionDeLaCaseActuellementSelectionnee[1], this.positionDeLaCaseActuellementSelectionnee[0],
							this.saFenetre.affichagejeu.getCarte(this.positionDeLaCaseActuellementSelectionnee[0],
									this.positionDeLaCaseActuellementSelectionnee[1]), this.saFenetre.lesJoueurs)) {
						JOptionPane.showMessageDialog(null, "Trop loin ou personne !", "Probl�me", JOptionPane.ERROR_MESSAGE);
					}
				}
				break;
			case "d�placer":
				if (!Evenements.Boutons.deplace((Personnage) this.trucActuellementSelectionne, this.positionDeLaCaseActuellementSelectionnee[1],
						this.positionDeLaCaseActuellementSelectionnee[0], this.saFenetre.affichagejeu.getCarte(
								this.positionDeLaCaseActuellementSelectionnee[0], this.positionDeLaCaseActuellementSelectionnee[1]),
								this.saFenetre.lesJoueurs)) {
					JOptionPane.showMessageDialog(null, "Trop loin ou occup� !", "Probl�me", JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "soigner":
				if (!Evenements.Boutons.soigne((Personnage) this.trucActuellementSelectionne, this.positionDeLaCaseActuellementSelectionnee[1],
						this.positionDeLaCaseActuellementSelectionnee[0], this.saFenetre.affichagejeu.getCarte(
								this.positionDeLaCaseActuellementSelectionnee[0], this.positionDeLaCaseActuellementSelectionnee[1]),
								this.saFenetre.lesJoueurs)) {
					JOptionPane.showMessageDialog(null, "Trop loin ou vide !", "Probl�me", JOptionPane.ERROR_MESSAGE);
				}
				break;
			default:
				System.out.println("probl�me lors de la recuperation de l'action complexe � effectuer");
		}
		this.actionEnCours = false;
		this.saFenetre.updateAffichage();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.ancienBatiment = this.unBatimentOuUneUnit�;
		JButton boutonAppuye = (JButton) e.getSource();
		switch (boutonAppuye.getText()) {
			case "d�truire":
				this.detruireUnObjet();
				break;
			case "d�placer":
				this.actionEnCours = true;
				this.quelleActionEnCours = "d�placer";
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
					JOptionPane.showMessageDialog(null, "Pas assez de place autour du batiment pour executer cette action", "Probl�me",
							JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "cavalier archer":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].isCavalierArcherCreated(this.positionDeLaCaseActuellementSelectionnee)) {
					JOptionPane.showMessageDialog(null, "Pas assez de place autour du batiment pour executer cette action", "Probl�me",
							JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "SuperMouton":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].IsSuperMoutonCreated(this.positionDeLaCaseActuellementSelectionnee)) {
					JOptionPane.showMessageDialog(null, "Pas assez de place autour du batiment pour executer cette action", "Probl�me",
							JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "catapultes":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].isCatapulteCreated(this.positionDeLaCaseActuellementSelectionnee)) {
					JOptionPane.showMessageDialog(null, "Pas assez de place autour du batiment pour executer cette action", "Probl�me",
							JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "milicien":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].isMilicienCreated(this.positionDeLaCaseActuellementSelectionnee)) {
					JOptionPane.showMessageDialog(null, "Pas assez de place autour du batiment pour executer cette action", "Probl�me",
							JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "chevalier":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].isChevalierCreated(this.positionDeLaCaseActuellementSelectionnee)) {
					JOptionPane.showMessageDialog(null, "Pas assez de place autour du batiment pour executer cette action", "Probl�me",
							JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "peon":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].isPeonCreated(this.positionDeLaCaseActuellementSelectionnee)) {
					JOptionPane.showMessageDialog(null, "Pas assez de place autour du batiment pour executer cette action", "Probl�me",
							JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "gal�re":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].isGalereCreated(this.positionDeLaCaseActuellementSelectionnee)) {
					JOptionPane.showMessageDialog(null, "Pas assez de place autour du batiment pour executer cette action", "Probl�me",
							JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "tranporteur":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].isTransporteurCreated(this.positionDeLaCaseActuellementSelectionnee)) {
					JOptionPane.showMessageDialog(null, "Pas assez de place autour du batiment pour executer cette action", "Probl�me",
							JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "magicien":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].isMagicirnrCreated(this.positionDeLaCaseActuellementSelectionnee)) {
					JOptionPane.showMessageDialog(null, "Pas assez de place autour du batiment pour executer cette action", "Probl�me",
							JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "healers":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].isHealerCreated(this.positionDeLaCaseActuellementSelectionnee)) {
					JOptionPane.showMessageDialog(null, "Pas assez de place autour du batiment pour executer cette action", "Probl�me",
							JOptionPane.ERROR_MESSAGE);
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
					JOptionPane.showMessageDialog(null, "Pas assez de place autour du batiment pour executer cette action", "Probl�me",
							JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "atelier de si�ge":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].isAtelierDeSiegeConstructed(this.positionDeLaCaseActuellementSelectionnee,
						this.saFenetre.affichagejeu.getCarte(this.positionDeLaCaseActuellementSelectionnee[1],
								this.positionDeLaCaseActuellementSelectionnee[0]))) {
					JOptionPane.showMessageDialog(null, "Pas assez de place autour du batiment pour executer cette action", "Probl�me",
							JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "Caserne":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].isCaserneConstructed(this.positionDeLaCaseActuellementSelectionnee,
						this.saFenetre.affichagejeu.getCarte(this.positionDeLaCaseActuellementSelectionnee[1],
								this.positionDeLaCaseActuellementSelectionnee[0]))) {
					JOptionPane.showMessageDialog(null, "Pas assez de place autour du batiment pour executer cette action", "Probl�me",
							JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "Ecurie":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].isEcurieConstructed(this.positionDeLaCaseActuellementSelectionnee,
						this.saFenetre.affichagejeu.getCarte(this.positionDeLaCaseActuellementSelectionnee[1],
								this.positionDeLaCaseActuellementSelectionnee[0]))) {
					JOptionPane.showMessageDialog(null, "Pas assez de place autour du batiment pour executer cette action", "Probl�me",
							JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "Hotel de ville":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].isHotelDeVilleConstructed(this.positionDeLaCaseActuellementSelectionnee,
						this.saFenetre.affichagejeu.getCarte(this.positionDeLaCaseActuellementSelectionnee[1],
								this.positionDeLaCaseActuellementSelectionnee[0]))) {
					JOptionPane.showMessageDialog(null, "Pas assez de place autour du batiment pour executer cette action", "Probl�me",
							JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "Mur":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].isMurConstructed(this.positionDeLaCaseActuellementSelectionnee,
						this.saFenetre.affichagejeu.getCarte(this.positionDeLaCaseActuellementSelectionnee[1],
								this.positionDeLaCaseActuellementSelectionnee[0]))) {
					JOptionPane.showMessageDialog(null, "Pas assez de place autour du batiment pour executer cette action", "Probl�me",
							JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "Port":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].isPortConstructed(this.positionDeLaCaseActuellementSelectionnee,
						this.saFenetre.affichagejeu.getCarte(this.positionDeLaCaseActuellementSelectionnee[1],
								this.positionDeLaCaseActuellementSelectionnee[0]))) {
					JOptionPane.showMessageDialog(null, "Pas assez de place autour du batiment pour executer cette action", "Probl�me",
							JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "mine or":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].isMineOrConstructed(this.positionDeLaCaseActuellementSelectionnee,
						this.saFenetre.affichagejeu.getCarte(this.positionDeLaCaseActuellementSelectionnee[1],
								this.positionDeLaCaseActuellementSelectionnee[0]))) {
					JOptionPane.showMessageDialog(null, "Pas assez de place autour du batiment pour executer cette action", "Probl�me",
							JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "mine nourriture":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].isMineNourritureConstructed(this.positionDeLaCaseActuellementSelectionnee,
						this.saFenetre.affichagejeu.getCarte(this.positionDeLaCaseActuellementSelectionnee[1],
								this.positionDeLaCaseActuellementSelectionnee[0]))) {
					JOptionPane.showMessageDialog(null, "Pas assez de place autour du batiment pour executer cette action", "Probl�me",
							JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "mine bois":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].isMineBoisConstructed(this.positionDeLaCaseActuellementSelectionnee,
						this.saFenetre.affichagejeu.getCarte(this.positionDeLaCaseActuellementSelectionnee[1],
								this.positionDeLaCaseActuellementSelectionnee[0]))) {
					JOptionPane.showMessageDialog(null, "Pas assez de place autour du batiment pour executer cette action", "Probl�me",
							JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "mine fer":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].isMineFerConstructed(this.positionDeLaCaseActuellementSelectionnee,
						this.saFenetre.affichagejeu.getCarte(this.positionDeLaCaseActuellementSelectionnee[1],
								this.positionDeLaCaseActuellementSelectionnee[0]))) {
					JOptionPane.showMessageDialog(null, "Pas assez de place autour du batiment pour executer cette action", "Probl�me",
							JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "mine pierre":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].isMinePierreConstructed(this.positionDeLaCaseActuellementSelectionnee,
						this.saFenetre.affichagejeu.getCarte(this.positionDeLaCaseActuellementSelectionnee[1],
								this.positionDeLaCaseActuellementSelectionnee[0]))) {
					JOptionPane.showMessageDialog(null, "Pas assez de place autour du batiment pour executer cette action", "Probl�me",
							JOptionPane.ERROR_MESSAGE);
				}
				break;

			case "rechercher":
				Evenements.Boutons.cherche((Personnage) this.trucActuellementSelectionne);
				break;

			case "Tour des mages":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].isTourDesMagesConstructed(this.positionDeLaCaseActuellementSelectionnee,
						this.saFenetre.affichagejeu.getCarte(this.positionDeLaCaseActuellementSelectionnee[1],
								this.positionDeLaCaseActuellementSelectionnee[0]))) {
					JOptionPane.showMessageDialog(null, "Pas assez de place autour du batiment pour executer cette action", "Probl�me",
							JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "Tourelle":
				if (!this.saFenetre.lesJoueurs[PanelResrc.joueurencours].isTourelleConstructed(this.positionDeLaCaseActuellementSelectionnee,
						this.saFenetre.affichagejeu.getCarte(this.positionDeLaCaseActuellementSelectionnee[1],
								this.positionDeLaCaseActuellementSelectionnee[0]))) {
					JOptionPane.showMessageDialog(null, "Pas assez de place autour du batiment pour executer cette action", "Probl�me",
							JOptionPane.ERROR_MESSAGE);
				}
				break;
			default:
				System.out.println("probl�me lors de la recuperation de l'action � affectuer");
		}
		this.saFenetre.updateAffichage();
	}
}
