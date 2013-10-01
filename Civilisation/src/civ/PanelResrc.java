package civ;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelResrc extends JPanel {
	/*
	 * classe où sera défini le panel en haut de la fenetre principal, et qui
	 * servira à afficher les ressources dispos, les tours...
	 */

	// **********VARIABLES
	JLabel or, nourriture, bois;

	// **********CONSTRUCTEURS
	public PanelResrc() {
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		this.or = new JLabel("or: 100");
		this.add(this.or);
		this.nourriture = new JLabel("nourriture: 100");
		this.add(this.nourriture);
		this.bois = new JLabel("bois: 100");
		this.add(this.bois);
	}
	// **********MUTATEURS

	// **********METHODES
}
