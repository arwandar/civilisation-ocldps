package civ;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class FntPrcpl extends JFrame {
	/*
	 * classe où sera défini la fenetre principale du jeu
	 */

	JPanel fenetre;
	JScrollPane jsp;
	PanelResrc barrehaute;
	PanelBas barrebasse;
	PanelPrcpl affichagejeu;
	static int largeur, hauteur;

	// **********CONSTRUCTEURS
	protected FntPrcpl() {
		largeur = 700;
		hauteur = 500;
		initParDefaut(largeur, hauteur);

		this.setLayout(null);

		this.barrehaute = new PanelResrc();
		this.barrehaute.setBounds(0, 0, largeur, (10 * hauteur / 100));
		getContentPane().add(this.barrehaute);

		this.barrebasse = new PanelBas();
		this.barrebasse.setBounds(0, (hauteur - (30 * hauteur / 100)), largeur, (30 * hauteur / 100));
		getContentPane().add(this.barrebasse);

		this.affichagejeu = new PanelPrcpl();
		this.affichagejeu.setBounds(0, (10 * hauteur / 100), largeur, hauteur - (40 * hauteur / 100));
		getContentPane().add(this.affichagejeu);

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

}
