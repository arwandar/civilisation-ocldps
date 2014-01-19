package Comportement;

import Unites.Personnage;

/**
 * Définit que l'unité se déplace sur l'eau
 * @author isen
 *
 */
public class Voler implements Deplacer {
	public void deplacer(Personnage personnage){
		//System.out.println("Je me déplace en flottant");
		personnage.setMouvement(60);
	}
}