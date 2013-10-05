package civ;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import joueur.Joueur;

public class PanelResrc extends JPanel {
	/*
	 * classe où sera défini le panel en haut de la fenetre principal, et qui
	 * servira à afficher les ressources dispos, les tours...
	 */

	// **********VARIABLES
	JLabel or, nourriture, bois;
	Joueur ceJoueur;

	// **********CONSTRUCTEURS
	public PanelResrc(Joueur joueur) {
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		this.or = new JLabel();
		this.add(this.or);
		this.nourriture = new JLabel();
		this.add(this.nourriture);
		this.bois = new JLabel();
		this.add(this.bois);
		this.ceJoueur = joueur;
	}
	// **********MUTATEURS

	// **********METHODES
	public void updateAffichageRessource(){
		this.or.setText("or: "+this.ceJoueur.getOr());
		this.nourriture.setText("nourriture: "+this.ceJoueur.getNourriture());
		this.bois.setText("bois: "+this.ceJoueur.getBois());
	}
	
}
