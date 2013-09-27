package civ;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class FntPrcpl extends JFrame {
	/*
	 * classe où sera défini la fenetre principale du jeu
	 */

	// **********VARIABLES
	JPanel fenetre;
	PanelResrc barrehaute;
	PanelBas barrebasse;
	PanelPrcpl affichagejeu;

	// **********CONSTRUCTEURS
	protected FntPrcpl() {
		int largeur = 700, hauteur = 500;
		initParDefaut(largeur, hauteur);

		// this.fenetre = new JLayeredPane();

		this.setLayout(null);

		this.barrehaute = new PanelResrc();
		this.barrehaute.setBounds(0, 0, largeur, (10 * hauteur / 100));
		getContentPane().add(this.barrehaute, 0);

		this.barrebasse = new PanelBas();
		this.barrebasse.setBounds(0, (hauteur - (30 * hauteur / 100)), largeur, (30 * hauteur / 100));
		getContentPane().add(this.barrebasse, 1);
		
		this.fenetre = new JPanel();
		this.fenetre.setBounds(0, (10 * hauteur / 100), largeur, (60*hauteur/100));
		getContentPane().add(this.fenetre);
		this.fenetre.setLayout(null);

		this.affichagejeu = new PanelPrcpl();
		this.affichagejeu.setBounds(-100, -100, largeur + 100, hauteur + 100);
		this.fenetre.add(this.affichagejeu);


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
