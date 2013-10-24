package civ;

import javax.swing.JFrame;

import joueur.Joueur;

public class FntPrcpl extends JFrame {
	/*
	 * classe où sera défini la fenetre principale du jeu
	 */

	PanelBas barrebasse;
	PanelPrcpl affichagejeu;
	PanelResrc barrehaute;
	int largeur, hauteur;
	Joueur[] lesJoueurs;

	// **********CONSTRUCTEURS
	protected FntPrcpl(Joueur[] lesJoueurs) {
		largeur = 1500;
		hauteur = 1000;
		initParDefaut(largeur, hauteur);

		this.setLayout(null);

		this.lesJoueurs = lesJoueurs;

		// init barre haute
		this.barrehaute = new PanelResrc(lesJoueurs, this);
		this.barrehaute.setBounds(0, 0, largeur, 50);
		getContentPane().add(this.barrehaute);

		// init big map
		this.affichagejeu = new PanelPrcpl(this.largeur, this.hauteur, this);
		this.affichagejeu.setBounds(0, 50, largeur, hauteur - 50 - (30 * hauteur / 100));
		getContentPane().add(this.affichagejeu);

		// init barre basse
		this.barrebasse = new PanelBas(this.hauteur, this.largeur, this);
		getContentPane().add(this.barrebasse);

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

}
