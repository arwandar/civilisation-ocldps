package civ;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.ScrollPane;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

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

		// this.fenetre = new JLayeredPane();

		this.setLayout(null);

		this.barrehaute = new PanelResrc();
		this.barrehaute.setBounds(0, 0, largeur, (10 * hauteur / 100));
		getContentPane().add(this.barrehaute, 0);

		this.barrebasse = new PanelBas();
		this.barrebasse.setBounds(0, (hauteur - (30 * hauteur / 100)), largeur, (30 * hauteur / 100));
		getContentPane().add(this.barrebasse, 1);

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
