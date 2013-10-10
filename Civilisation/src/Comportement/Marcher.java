package Comportement;

import Unites.Personnage;

/**
 * Définit que l'unité se déplace à pied
 * @author isen
 *
 */
public class Marcher implements Deplacer {
	public void deplacer(Personnage personnage){
		//System.out.println("Je me déplace à pied");
		personnage.setMouvement(3);
	}
}
