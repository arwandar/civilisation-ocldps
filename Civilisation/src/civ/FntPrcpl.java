package civ;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import joueur.Joueur;

public class FntPrcpl extends JFrame {
	/*
	 * classe où sera défini la fenetre principale du jeu
	 */

	JPanel fenetre, barrehaute;
	JScrollPane jsp;
	PanelResrc barrehautej1, barrehautej2;
	PanelBas barrebasse;
	PanelPrcpl affichagejeu;
	int largeur, hauteur;
	Joueur j1, j2;

	// **********CONSTRUCTEURS
	protected FntPrcpl() {
		largeur = 1500;
		hauteur = 1000;
		initParDefaut(largeur, hauteur);

		this.setLayout(null);

		final CardLayout cl = new CardLayout();
		final String[] listContent = { "player1", "player2" };

		// init barre haute
		this.barrehaute = new JPanel();
		this.barrehaute.setBounds(0, 0, largeur, (10 * hauteur / 100));
		this.barrehaute.setLayout(cl);
		getContentPane().add(this.barrehaute);

		this.barrehautej1 = new PanelResrc(j1);
		this.barrehaute.add(this.barrehautej1, listContent[0]);
		this.barrehautej2 = new PanelResrc(j1);
		this.barrehaute.add(this.barrehautej2, listContent[1]);

		// init big map
		this.affichagejeu = new PanelPrcpl(this.largeur, this.hauteur, this);
		this.affichagejeu.setBounds(0, (10 * hauteur / 100), largeur, hauteur - (40 * hauteur / 100));
		getContentPane().add(this.affichagejeu);

		// init barre basse
		this.barrebasse = new PanelBas(this.hauteur, this.largeur, this);
		getContentPane().add(this.barrebasse);

		int[] v={10,10};
		
		//BatMur test1 = new BatMur(v);
		
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
