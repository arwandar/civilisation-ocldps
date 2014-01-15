package civ;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import joueur.Joueur;

public class PanelResrc extends JPanel implements ActionListener {
	/*
	 * classe o� sera d�fini le panel en haut de la fenetre principal, et qui
	 * servira � afficher les ressources dispos, les tours...
	 */

	// **********VARIABLES
	JLabel or, nourriture, bois, pierre, fer, os;
	JButton finDeTour;
	int indice;
	Joueur[] lesJoueurs;
	FntPrcpl saFenetre;
	public static boolean findetour = false;
	public static int joueurencours = 0;

	// **********CONSTRUCTEURS
	public PanelResrc(Joueur[] lesJoueurs, FntPrcpl fenetre) {
		indice = 0;

		this.lesJoueurs = lesJoueurs;
		this.saFenetre = fenetre;

		this.setLayout(new FlowLayout(FlowLayout.CENTER));

		this.or = new JLabel();
		this.add(this.or);
		this.nourriture = new JLabel();
		this.add(this.nourriture);
		this.bois = new JLabel();
		this.add(this.bois);
		this.pierre = new JLabel();
		this.add(this.pierre);
		this.fer = new JLabel();
		this.add(this.fer);
		this.os = new JLabel();
		this.add(this.os);

		this.finDeTour = new JButton("fin de tour");
		this.finDeTour.addActionListener(this);
		this.add(this.finDeTour);

		updateAffichageRessource();
	}

	// **********MUTATEURS

	// **********METHODES
	public void updateAffichageRessource() {
		if (indice < lesJoueurs.length) {
			this.or.setText("or " + lesJoueurs[indice].getOr());
			this.nourriture.setText("nourriture " + lesJoueurs[indice].getNourriture());
			this.bois.setText("bois " + lesJoueurs[indice].getBois());
			this.pierre.setText("pierre " + lesJoueurs[indice].getPierre());
			this.fer.setText("fer " + lesJoueurs[indice].getFer());
			this.os.setText("os " + lesJoueurs[indice].getOs());
		}
	}

	public void actionPerformed(ActionEvent e) {
		
		this.joueurencours++;
		if (this.joueurencours == this.lesJoueurs.length) {
			this.joueurencours = 0;
		}
		this.saFenetre.updateAffichage();
		this.findetour = true;
	}
}
