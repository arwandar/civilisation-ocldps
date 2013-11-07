package civ;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import joueur.Joueur;

public class FntPrcpl extends JFrame {
	/*
	 * classe où sera défini la fenetre principale du jeu
	 */

	PanelBas barrebasse;
	public PanelPrcpl affichagejeu;
	PanelResrc barrehaute;
	JPanel jeu, menu, editeurMap, creationPerso, fenetre;
	int largeur, hauteur;
	Joueur[] lesJoueurs;
	JButton demarrerB, creaPersoB, editMapB;
	CardLayout cl = new CardLayout();
	String[] listContent = {"menu", "jeu", "creationPerso", "editeurMap"};

	// **********CONSTRUCTEURS
	public FntPrcpl(Joueur[] lesJoueurs) {
		largeur = 1500;
		hauteur = 1000;
		initParDefaut(largeur, hauteur);

		this.lesJoueurs = new Joueur[lesJoueurs.length];
		for(int i=0; i<lesJoueurs.length; i++){
			this.lesJoueurs[i] = lesJoueurs[i];
		}
		
		this.fenetre = new JPanel(cl);
		
		initMenu();
		initJeu();
		initCreationPerso();
		initEditeurMap();
	
		this.getContentPane().add(this.fenetre);
		this.setVisible(true);
	}

	// **********MUTATEURS

	// **********METHODES
	private void initParDefaut(int largeur, int hauteur) {

		this.setSize(largeur, hauteur);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}

	protected void updateAffichage() {
		this.affichagejeu.updateCarte();
		this.barrebasse.updateMap();
		this.barrehaute.updateAffichageRessource();
	}
	
	protected void initJeu(){
		this.jeu = new JPanel();		
		this.jeu.setLayout(null);
		
		// init barre haute
		this.barrehaute = new PanelResrc(lesJoueurs, this);
		this.barrehaute.setBounds(0, 0, largeur, 50);
		this.jeu.add(this.barrehaute);

		// init big map
		this.affichagejeu = new PanelPrcpl(this.largeur, this.hauteur, this);
		this.affichagejeu.setBounds(0, 50, largeur, hauteur - 50 - (30 * hauteur / 100));
		this.jeu.add(this.affichagejeu);

		// init barre basse
		this.barrebasse = new PanelBas(this.hauteur, this.largeur, this);
		this.jeu.add(this.barrebasse);
		
		this.fenetre.add(this.jeu, listContent[1]);
	}

	protected void initMenu(){
		this.menu = new JPanel();
		
		this.demarrerB = new JButton("demarrer une partie");
		this.demarrerB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.next(fenetre);				
			}
		});
		this.menu.add(this.demarrerB);
		
		this.editMapB = new JButton("editer une nouvelle map");
		this.editMapB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(fenetre, listContent[3]);				
			}
		});
		this.menu.add(this.editMapB);
		
		this.creaPersoB = new JButton("creation des joueurs");
		this.creaPersoB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(fenetre, listContent[2]);
			}
		});
		this.menu.add(this.creaPersoB);
		
		this.fenetre.add(this.menu, listContent[0]);
	}
	
	protected void initCreationPerso(){
		this.creationPerso = new JPanel();
		
		JButton bouh = new JButton("revenir au menu precedent");
		bouh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(fenetre, listContent[0]);				
			}
		});
		
		this.creationPerso.add(bouh);
		this.fenetre.add(this.creationPerso, listContent[2]);
	}
	
	protected void initEditeurMap(){
		this.editeurMap = new JPanel();
		
		JButton bouh = new JButton("revenir au menu precedent");
		bouh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(fenetre, listContent[0]);				
			}
		});
		
		this.editeurMap.add(bouh);
		this.fenetre.add(this.editeurMap, listContent[3]);
	}
}
