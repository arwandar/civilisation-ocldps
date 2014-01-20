package civ;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Unites.Test;
import joueur.Joueur;

public class PanelResrc extends JPanel implements ActionListener {
	/*
	 * classe o� sera d�fini le panel en haut de la fenetre principal, et qui
	 * servira � afficher les ressources dispos, les tours...
	 */

	// **********VARIABLES
	JLabel joueur, label;

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

		this.joueur = new JLabel();
		this.add(this.joueur);

		this.label = new JLabel();
		this.add(this.label);

		this.finDeTour = new JButton("fin de tour");
		this.finDeTour.addActionListener(this);
		this.add(this.finDeTour);

		updateAffichageRessource();
	}

	// **********MUTATEURS

	// **********METHODES
	public void updateAffichageRessource() {
		this.joueur.setText("Joueur " + (this.joueurencours + 1) + " : ");
		this.joueur.setForeground(this.saFenetre.lesJoueurs[joueurencours].getSaCouleur());

		this.label.setText("or : " + lesJoueurs[joueurencours].getOr() + " / fer : " + lesJoueurs[joueurencours].getFer() + " / nourriture : "
				+ lesJoueurs[joueurencours].getNourriture() + " / bois : " + lesJoueurs[joueurencours].getBois() + " / pierre : "
				+ lesJoueurs[joueurencours].getPierre() + " / os : " + lesJoueurs[joueurencours].getOs());
	}

	public void actionPerformed(ActionEvent e) {

		for (int i = 0; i < lesJoueurs.length; i++) { // test sur tous les
			// joueurs pour voir si
			// la partie est finie
			if (Unites.Test.isFini(lesJoueurs[i]))
				Unites.Test.partieEnCours = false;
		}

		this.joueurencours++;
		if (this.joueurencours == this.lesJoueurs.length) {
			this.joueurencours = 0;
		}
		this.saFenetre.updateAffichage();
		this.findetour = true;

		for (int i = 0; i <= 1; i++) {
			if (Test.isFini(this.lesJoueurs[i])) {
				JOptionPane jpop = new JOptionPane();
				JOptionPane.showMessageDialog(null, this.lesJoueurs[i].getNom() + " a perdu!", "Fin de partie", JOptionPane.PLAIN_MESSAGE);
				this.saFenetre.dispose();
			}
		}

		Unites.Test.debutDeTour(lesJoueurs[joueurencours]); // lance la raz du
		// joueur suivant

	}
}
