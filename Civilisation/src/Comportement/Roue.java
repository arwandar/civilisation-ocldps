package Comportement;

import Unites.Personnage;

/**
 * Définit que l'unité se déplace sur des roues
 * @author isen
 *
 */
public class Roue implements Deplacer {
	public void deplacer(Personnage personnage){
		//System.out.println("Je me déplace sur des roues");
		personnage.setMouvement(2);
	}
}