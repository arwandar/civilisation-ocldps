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
	 * classe où sera défini le panel en haut de la fenetre principal, et qui
	 * servira à afficher les ressources dispos, les tours...
	 */

	// **********VARIABLES
	JLabel or, nourriture, bois, pierre, fer, os, joueur;
	
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
			this.joueur.setText("Joueur "+ (this.joueurencours+1));
			this.joueur.setForeground(this.saFenetre.lesJoueurs[joueurencours].getSaCouleur());
			
			this.or.setText("or " + lesJoueurs[joueurencours].getOr());
			this.nourriture.setText("nourriture " + lesJoueurs[joueurencours].getNourriture());
			this.bois.setText("bois " + lesJoueurs[joueurencours].getBois());
			this.pierre.setText("pierre " + lesJoueurs[joueurencours].getPierre());
			this.fer.setText("fer " + lesJoueurs[joueurencours].getFer());
			this.os.setText("os " + lesJoueurs[joueurencours].getOs());
		
	}

	public void actionPerformed(ActionEvent e) {
		
		
		for (int i=0; i < lesJoueurs.length;i++){ //test sur tous les joueurs pour voir si la partie est finie
			if(Unites.Test.isFini(lesJoueurs[i]))
				Unites.Test.partieEnCours=false;
		}
		
		
		
		this.joueurencours++;
		if (this.joueurencours == this.lesJoueurs.length) {
			this.joueurencours = 0;
		}
		this.saFenetre.updateAffichage();
		this.findetour = true;
		
		for(int i=0; i<=1; i++)
		{
			if(Test.isFini(this.lesJoueurs[i]))
			{
				JOptionPane jpop = new JOptionPane();
				JOptionPane.showMessageDialog(null, this.lesJoueurs[i].getNom() + " a gagné!",
						"Fin de partie", JOptionPane.PLAIN_MESSAGE);
				this.saFenetre.dispose();
			}
		}
		
		Unites.Test.debutDeTour(lesJoueurs[joueurencours]); //lance la raz du joueur suivant
		
	}
}
