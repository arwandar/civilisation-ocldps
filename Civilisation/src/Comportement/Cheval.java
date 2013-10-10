package Comportement;

import Unites.Personnage;

/**
 * Définit que l'unité se déplace sur une monture
 * @author isen
 *
 */
public class Cheval implements Deplacer {
	public void deplacer(Personnage personnage){
		//System.out.println("Je me déplace à cheval");
		personnage.setMouvement(6);
	}
}